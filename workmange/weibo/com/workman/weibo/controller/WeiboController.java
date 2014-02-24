package com.workman.weibo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.workman.commons.util.StringUtility;
import com.workman.commons.util.SysLogUtils;
import com.workman.commons.util.WeiboUtils;
import com.workman.mission.dao.MissionDao;
import com.workman.mission.model.MissionHandleModel;
import com.workman.mission.model.MissionModel;
import com.workman.permission.util.SessionUtils;
import com.workman.sysman.dao.AccountDao;
import com.workman.sysman.model.AccountModel;
import com.workman.weibo.dao.WeiboDao;
import com.workman.weibo.model.AccessTokenModel;

import weibo4j.Oauth;
import weibo4j.Users;
import weibo4j.http.AccessToken;
import weibo4j.http.HttpClient;
import weibo4j.http.Response;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

/**
 * 处理与微博相关的操作
 * @author lyw
 *
 */
@Controller
@RequestMapping("/weibo/*")
public class WeiboController {
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private WeiboDao weiboDao;
	
	@Autowired
	private MissionDao missionDao;
	/**
	 * 微博授权认证
	 * @param code
	 * @param req
	 * @throws IOException 
	 */
	@RequestMapping("auth.do")
	public void auth(String code,HttpServletRequest req,
			HttpServletResponse res) throws IOException{
		Oauth oa = new Oauth();
		String result = null;
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=UTF-8");
		try {
			AccessToken tok = oa.getAccessTokenByCode(code);
			User user = getWeiboUesr(tok.getAccessToken(),tok.getUid());
			AccountModel account = SessionUtils.getUser(req);
			if(account == null){
				result = "<script>alert('认证失败，登陆微博与用户绑定微博不一致！');window.location.href='../internal/welcome.do';</script>";
			}else{
				AccessTokenModel tokenModel = weiboDao.addOrUpdateToken(tok, user,account);
				if(account.getWeibo() == null){
					account = accountDao.updateAccount(account,tokenModel.getWeiboName());
				}else if(!account.getWeibo().equals(tokenModel.getWeiboName())){
					result = "<script>alert('请注意，当前授权账号与历史授权有变动。若要更改授权，请收回当前授权后重新进行授权');window.location.href='../internal/welcome.do';</script>";
				}
				SessionUtils.putAccessToken(req, tokenModel);
				SessionUtils.putUserInSession(req, account);
				result = "<script>alert('认证成功！');window.location.href='../internal/welcome.do';</script>";
			}
		} catch (WeiboException e) {
			SysLogUtils.error(getClass(), e, "获取微博认证失败");
			result = "<script>alert('认证出错，请重新认证');window.location.href='../internal/welcome.do';</script>";
		}catch(Exception e){
			SysLogUtils.error(getClass(), e, "保存微博认证失败");
			result = "<script>alert('与账号绑定失败！');window.location.href='../internal/welcome.do';</script>";
		}
		res.getWriter().print(result);
	}
	private User getWeiboUesr(String accessToken, String uid) throws WeiboException {
		Users users = new Users();
		users.setToken(accessToken);
		User user = users.showUserById(uid);
		return user;
	}
	@RequestMapping("sysWeibo.do")
	@ResponseBody
	public Integer sysWeibo(Integer id,HttpServletRequest req){
		AccessTokenModel tokenModel =getAccessToken(req, id);
		if(tokenModel == null){
			return -1;
		}else{
			try {
				User user = getWeiboUesr(tokenModel.getToken(), tokenModel.getUid());
				if(user != null){
					SessionUtils.putAccessToken(req, tokenModel);
					return 1;
				}else{
					return -3;
				}
			} catch (WeiboException e) {
				SysLogUtils.error(getClass(), e, "获取微博授权失败");
				return -2;
			}
		}
	}
	/**
	 * 验证手机客户端是否已绑定站内用户
	 * @param id 微博id
	 * @param weiboName 微博名称
	 * @return
	 */
	@RequestMapping("sysClient.do")
	@ResponseBody
	public Integer sysClient(@RequestParam(required=false)String id,
			@RequestParam(required=false)String weiboName){
		int result = 0;
		if(StringUtility.isNotBlank(weiboName)){
			AccountModel account = accountDao.getAccount(weiboName, 2);
			if(account != null){
				result =  account.getId();
			}else{
				result = -1;
			}
		}else if(StringUtility.isNotBlank(id)){
			AccessTokenModel token = weiboDao.getToken(id);
			if(token != null){
				result =  token.getAccountId();
			}else{
				result = -1;
			}
		}else{
			result =  -400;
		}
		return result;
	}
	/**
	 * 绑定站内用户
	 * @param userName 用户名
	 * @param password 密码
	 * @param uid 微博id
	 * @param weiboName 微博名称
	 * @return 绑定用户id 
	 *  返回-1 不存在的用户 返回-2 密码错误 返回-3 已绑定微博 -4操作异常
	 */
	@RequestMapping("bindAccount.do")
	@ResponseBody
	public Integer bindAccount(String userName,String password,
			String uid,String weiboName){
		int result = 0;
		try {
			AccountModel account = accountDao.getAccount(userName, 1);
			if(account != null){
				if(account.getPassword().equals(password)){
					account = accountDao.updateAccount(account, weiboName);
					AccessTokenModel token = weiboDao.getToken(account.getId());
					if(token != null){
						result = -3;
					}else{
						token = new AccessTokenModel();
						token.setAccountId(account.getId());
						token.setUid(uid);
						token.setWeiboName(weiboName);
						weiboDao.add(token);
						result = account.getId();
					}
				}else{
					result = -2;
				}
			}else{
				result = -1;
			}
		} catch (Exception e) {
			SysLogUtils.error(WeiboController.class, e, "操作异常");
			result = -4;
		}
		return result;
	}
	
	@RequestMapping("goAccessPage.do")
	public String goAccessPage(HttpServletRequest req,
			ModelMap model){
		model.addAttribute("accessUrl", WeiboUtils.getAccessWeiboUrl());
		return "weibo/access";
	}
	@RequestMapping("goRevokeAccessPage.do")
	public String goRevokeAccessPage(HttpServletRequest req){
		SessionUtils.removeMainUrl(req);
		return "weibo/revoke";
	}
	@RequestMapping("revoke.do")
	@ResponseBody
	public int revokeAccess(HttpServletRequest req){
		HttpClient client = new HttpClient();
		int result = 0;
		try {
			AccessTokenModel token = SessionUtils.getAccessToken(req);
			if(token != null){
				client.setToken(token.getToken());
				Response res = client.get("https://api.weibo.com/oauth2/revokeoauth2?access_token="+token.getToken());
				if(res.asJSONObject().getBoolean("result")){
					result = 1;
				}
			}else{
				result = -1;
			}
		} catch (Exception e) {
			SysLogUtils.error(getClass(), e, "收回授权失败！");
			result = -2;
		}
		return result;
	}
	private AccessTokenModel getAccessToken(HttpServletRequest req,Integer id) {
		AccessTokenModel token = SessionUtils.getAccessToken(req);
		if(token == null){
			if(id == null){
				id = SessionUtils.getUser(req).getId();
			}
			token = weiboDao.getToken(id);
		}
		return token;
	}
	/**
	 * 
	 * @param id
	 * @param missionId
	 * @param handleId
	 * @return -1 你未进行微博绑定 -2通知对象未绑定微博  -3 微博验证出错 -4 发送微博失败
	 */
	@RequestMapping("sendWeibo.do")
	@ResponseBody
	public int sendWeibo(int id,int missionId,
			@RequestParam(required=false)Integer handleId){
		int toId = 0 ;//@的账号id
		String weiboStr = null;
		MissionModel mission = missionDao.getMission(missionId);
		int mStatu = mission.getStatus();
		switch (mStatu) {
		case 1://新建的任务，没有处理记录
			toId = mission.getHandlerId();
			weiboStr = "我给你分配了任务，请到任务模块查看或登录管理系统进行处理";
			break;
		case 2://有处理记录的
			MissionHandleModel handleInfo =  missionDao.getMissionHandle(handleId);
			toId = handleInfo.getToId();
			weiboStr = "我给你转发了任务，请到任务模块查看或登录管理系统进行处理";
			break;
		case 3://已完成的任务
			toId = mission.getSponsorId();
			weiboStr = "我已完成了任务，请查看";
			break;
		}
		AccessTokenModel sToken = weiboDao.getToken(id);
		AccessTokenModel toToken = weiboDao.getToken(toId);
		if(sToken == null){
			return -1;
		}
		if(toToken == null){
			return -2;
		}
		User user = null;
		try {//验证token
			user = getWeiboUesr(sToken.getToken(), sToken.getUid());
		} catch (WeiboException e) {
			SysLogUtils.error(WeiboController.class, e, "验证出错");
			return -3;
		}
		if(user != null){
			try {
				WeiboUtils.sendMsg(sToken.getToken(),toToken.getWeiboName(),weiboStr);
				return 1;
			} catch (WeiboException e) {
				SysLogUtils.error(WeiboController.class, e, "验证出错");
				return -4;
			}
		}
		return 0;
	}
}
