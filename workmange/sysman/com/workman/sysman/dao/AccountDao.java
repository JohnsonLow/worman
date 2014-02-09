package com.workman.sysman.dao;

import java.util.List;

import com.workman.commons.po.ResponseModel;
import com.workman.sysman.model.AccountModel;

public interface AccountDao {
	
	ResponseModel getAccountList(Integer posCode,
			Integer depCode,String name,
			int page,int size);

	void insertAccount(AccountModel account);

	void updateAccount(AccountModel account);

	void delete(int id);

	AccountModel getAccount(int id);
	
	AccountModel getAccount(String userName);


	void updateAccount(String name, String phone, String weibo,
			int id);

	void updatePwd(int id, String password);

	List<AccountModel> getAccountByDep(Integer depCode);
}
