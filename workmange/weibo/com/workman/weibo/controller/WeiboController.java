package com.workman.weibo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.workman.commons.util.SysLogUtils;
import com.workman.permission.util.SessionUtils;
import com.workman.sysman.model.AccountModel;

import weibo4j.Oauth;
import weibo4j.Users;
import weibo4j.http.AccessToken;
import weibo4j.model.User;
import weibo4j.model.WeiboException;
@Controller
public class WeiboController {
	/**
	 * 微博授权认证
	 * @param code
	 * @param req
	 * @throws IOException 
	 */
	@RequestMapping("auth.do")
	public String auth(String code,HttpServletRequest req,
			HttpServletResponse res) throws IOException{
		Oauth oa = new Oauth();
		try {
			AccessToken tok = oa.getAccessTokenByCode(code);
			SessionUtils.putAccessToken(tok,req);
			return "redirect:accessUser.do";
		} catch (WeiboException e) {
			SysLogUtils.error(getClass(), e, "获取微博认证失败");
			res.setCharacterEncoding("utf-8");
			res.setContentType("text/html; charset=UTF-8");
			res.getWriter().print("<script>alert('认证出错，请重新认证');window.close();</script>");
			return null;
		}
	}
	@RequestMapping("accessUser.do")
	public void accessUser(HttpServletRequest req,
			HttpServletResponse res)throws Exception{
		AccessToken token = (AccessToken) SessionUtils.getAccessToken(req);
		Users users = new Users();
		users.setToken(token.getAccessToken());
		try {
			User user = users.showUserById(token.getUid());
			AccountModel currAcc = SessionUtils.getUser(req);
			res.setCharacterEncoding("utf-8");
			res.setContentType("text/html; charset=UTF-8");
			if(user.getUserDomain().equals(currAcc.getWeibo())){
				res.getWriter().print("<script>alert('认证成功！');window.close();</script>");
			}else{
				res.getWriter().print("<script>alert('登陆微博与绑定微博不一致，请重新绑定微博或修改登陆微博！');window.close();</script>");
			}
		} catch (WeiboException e) {
			SysLogUtils.error(getClass(), e, "获取微博信息失败");
		}
	}
}
