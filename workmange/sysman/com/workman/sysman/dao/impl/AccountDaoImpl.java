package com.workman.sysman.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workman.commons.po.ResponseModel;
import com.workman.commons.util.StringUtility;
import com.workman.sysman.dao.AccountDao;
import com.workman.sysman.model.AccountModel;
import com.workman.sysman.persistence.AccountMapper;
import com.workman.sysman.persistence.wrapper.AccountWrapper;
import com.workman.sysman.util.PageUtils;
@Service
public class AccountDaoImpl implements AccountDao {
	@Autowired
	private AccountMapper mapper;

	@Override
	public ResponseModel getAccountList(Integer level, Integer depCode,
			String name, int page, int size) {
		ResponseModel res = new ResponseModel();
		int count = mapper.getCount();
		res.setRowCount(count);
		res.setPageCount(PageUtils.getPageCount(count, size));
		int start = PageUtils.getStart(page,size);
		int end = PageUtils.getEnd(page,size);
		AccountWrapper wrapper = new AccountWrapper();
		wrapper.setAuthLevel(level);
		wrapper.setDepCode(depCode);
		if(StringUtility.isNotBlank(name)){
			wrapper.setName("%" + name + "%");
		}
		wrapper.setStart(start);
		wrapper.setEnd(end);
		res.setData(mapper.getList(wrapper));
		return res;
	}

	@Override
	public void insertAccount(AccountModel account) {
		mapper.insert(account);

	}

	@Override
	public void updateAccount(AccountModel account) {
		mapper.update(account);
	}

}
