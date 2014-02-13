package com.workman.weibo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weibo4j.http.AccessToken;
import weibo4j.model.User;

import com.workman.sysman.model.AccountModel;
import com.workman.weibo.dao.WeiboDao;
import com.workman.weibo.model.AccessTokenModel;
import com.workman.weibo.persistence.AccessTokenMapper;

@Service
public class WeiboDaoImpl implements WeiboDao {
	@Autowired
	private AccessTokenMapper mapper;

	@Override
	public AccessTokenModel addOrUpdateToken(AccessToken token, User user, AccountModel account) {
		AccessTokenModel tokenModel = mapper.getByAccountId(account.getId());
		if(tokenModel == null){//添加
			tokenModel = new AccessTokenModel();
			tokenModel.setUid(token.getUid());
			tokenModel.setAccountId(account.getId());
			tokenModel.setToken(token.getAccessToken());
			tokenModel.setWeiboName(user.getScreenName());
			mapper.add(tokenModel);
		}else{//更新
			tokenModel.setUid(token.getUid());
			tokenModel.setToken(token.getAccessToken());
			tokenModel.setWeiboName(user.getScreenName());
			mapper.update(tokenModel);
		}
		return tokenModel;

	}

	@Override
	public AccessTokenModel getToken(int accountId) {
		return mapper.getByAccountId(accountId);
	}

}
