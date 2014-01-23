package com.workman.sysman.dao;

import com.workman.commons.po.ResponseModel;
import com.workman.sysman.model.AccountModel;

public interface AccountDao {
	
	ResponseModel getAccountList(Integer level,
			Integer depCode,String name,
			int page,int size);

	void insertAccount(AccountModel account);

	void updateAccount(AccountModel account);
}
