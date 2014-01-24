package com.workman.sysman.persistence;

import java.util.List;

import com.workman.sysman.model.AccountModel;
import com.workman.sysman.persistence.wrapper.AccountWrapper;

public interface AccountMapper {
	
	void insert(AccountModel account);
	
	void update(AccountModel account);
	
	void delete(int id);
	
	int getCount(AccountWrapper wrapper);

	List<AccountModel> getList(AccountWrapper wrapper);

}
