package com.workman.sysman.dao;

import java.util.List;

import com.workman.commons.po.ResponseModel;
import com.workman.sysman.model.AccountModel;
import com.workman.sysman.persistence.AccountMapper;
/**
 * 对账号进行相关操作的类
 * @author lyw
 *
 */
public interface AccountDao {
	
	/**
	 * 
	 * @see AccountMapper#getCount(com.workman.sysman.persistence.wrapper.AccountWrapper)
	 * @see AccountMapper#getList(com.workman.sysman.persistence.wrapper.AccountWrapper)
	 * @param posCode 职位代码
	 * @param depCode 部门代码
	 * @param name 姓名
	 * @param page 页码 从1开始
	 * @param size 每页条数
	 * 
	 * @return ResponseModel 
	 */
	ResponseModel getAccountList(Integer posCode,
			Integer depCode,String name,
			int page,int size);

	/**
	 * @see AccountMapper#insert(AccountModel)
	 * @param account
	 */
	void insertAccount(AccountModel account);

	/**
	 * @see AccountMapper#update(AccountModel)
	 * @param account
	 */
	void updateAccount(AccountModel account);

	/**
	 * @see AccountMapper#delete(int)
	 * @param id
	 */
	void delete(int id);

	/**
	 * @see AccountMapper#getAccount(int)
	 * @param id
	 * @return 账号信息
	 */
	AccountModel getAccount(int id);
	
	/**
	 * 
	 * 通过用户名或微博账号获得账号信息
	 * @param condition 查询条件，应为账户名或微博账号
	 * @param type 1: condition为账户名 ; 2: condition为微博账号
	 * @see AccountMapper#getAccountByUserName(String)
	 * @see AccountMapper#getAccountByWeibo(String)
	 * @return 账号信息
	 * 
	 */
	AccountModel getAccount(String condition, int type);

	
	/**
	 * @see AccountMapper#updatePwd(java.util.Map)
	 * @param id
	 * @param password
	 */
	void updatePwd(int id, String password);

	/**
	 * 
	 * 
	 * @param depCode
	 * @param currId
	 * @return 账号列表
	 */
	List<AccountModel> getAccountByDep(Integer depCode,int currId);
}
