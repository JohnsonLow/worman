package com.workman.weibo.persistence;

import com.workman.weibo.model.AccessTokenModel;
/**
 * 对微博token信息进行本地存储操作
 * @author lyw
 *
 */
public interface AccessTokenMapper {
	
	void add(AccessTokenModel token);
	
	void update(AccessTokenModel token);
	/**
	 * 通过用户Id查询token信息
	 * @param accountId
	 * @return
	 */
	AccessTokenModel getByAccountId(Integer accountId);
}
