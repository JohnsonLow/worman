package com.workman.sysman.persistence;

import java.util.List;
import java.util.Map;

import com.workman.sysman.model.AccountModel;
import com.workman.sysman.persistence.wrapper.AccountWrapper;

/**
 * 
 * @author lyw
 *
 */
public interface AccountMapper {
	
	/**
	 * 新增账号
	 * @param account
	 */
	void insert(AccountModel account);
	
	/**
	 * 新增账号
	 * @param account
	 */
	void update(AccountModel account);
	
	/**
	 * 删除账号
	 * @param id 账号id
	 */
	void delete(int id);
	
	/**
	 * 获取符合条件的记录数
	 * @param wrapper
	 * @return
	 */
	int getCount(AccountWrapper wrapper);

	/**
	 * 通过条件，查询相关记录
	 * @param wrapper
	 * @return
	 */
	List<AccountModel> getList(AccountWrapper wrapper);

	/**
	 * 通过id获得账号信息
	 * @param id
	 * @return
	 */
	AccountModel getAccount(int id);
	
	/**
	 * 通过用户名获得账号信息
	 * @param name
	 * @return
	 */
	AccountModel getAccountByUserName(String name);

	/**
	 * 通过微博获得账号信息
	 * @param weiboDomain
	 * @return
	 */
	AccountModel getAccountByWeibo(String weiboDomain);
	

	/**
	 * 更新密码
	 * @param map
	 */
	void updatePwd(Map<String,Object> map);
	
	/**
	 * 通过部门编号查询账号信息
	 * @param depCode
	 * @param currId
	 * @return
	 */
	List<AccountModel> getByDep(AccountWrapper wrapper);

	void updateWeibo(AccountModel acc);


}
