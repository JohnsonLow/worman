package com.workman.weibo.dao;

import com.workman.sysman.model.AccountModel;
import com.workman.weibo.model.AccessTokenModel;

import weibo4j.http.AccessToken;
import weibo4j.model.User;

public interface WeiboDao {
	
	AccessTokenModel addOrUpdateToken(AccessToken token , User user, AccountModel account);
	
	AccessTokenModel getToken(int accountId);

}
