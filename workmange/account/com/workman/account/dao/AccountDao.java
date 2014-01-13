package com.workman.account.dao;

import com.workman.commons.po.ResponseModel;

public interface AccountDao {
	
	ResponseModel getAccountList(Integer level,
			String department,String name,
			int page,int size);
}
