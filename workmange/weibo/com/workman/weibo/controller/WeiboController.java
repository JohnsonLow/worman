package com.workman.weibo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.workman.commons.util.SysLogUtils;
import com.workman.commons.util.WeiboUtils;
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
 * 
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
				SessionUtils.putAccessToken(req, tokenModel);
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
}
