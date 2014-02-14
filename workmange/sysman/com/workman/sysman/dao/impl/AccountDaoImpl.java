package com.workman.sysman.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public ResponseModel getAccountList(Integer posCode, Integer depCode,
			String name, int page, int size) {
		ResponseModel res = new ResponseModel();
		AccountWrapper wrapper = new AccountWrapper();
		if (posCode == null) {
			posCode = 0;
		}
		if (depCode == null) {
			depCode = 0;
		}
		wrapper.setPosCode(posCode);
		wrapper.setDepCode(depCode);
//		wrapper.setCurrId(currAccount.getId());
		if (StringUtility.isNotBlank(name)) {
			wrapper.setName("%" + name + "%");
		}
		int count = mapper.getCount(wrapper);
		res.setRowCount(count);
		res.setPageCount(PageUtils.getPageCount(count, size));
		int start = PageUtils.getStart(page, size);
		int end = PageUtils.getEnd(page, size);
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

	@Override
	public void delete(int id) {
		mapper.delete(id);

	}

	@Override
	public AccountModel getAccount(int id) {
		return mapper.getAccount(id);
	}

	@Override
	public AccountModel getAccount(String condition, int type) {
		AccountModel account = null;
		switch (type) {
		case 1:
			account = mapper.getAccountByUserName(condition);
			break;
		case 2:
			account = mapper.getAccountByWeibo(condition);
			break;
		}
		return account;
	}


	@Override
	public void updatePwd(int id, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("password", password);
		mapper.updatePwd(map);

	}

	@Override
	public List<AccountModel> getAccountByDep(Integer depCode,int currId) {
		AccountWrapper wrapper = new AccountWrapper();
		wrapper.setDepCode(depCode);
		wrapper.setCurrId(currId);
		return mapper.getByDep(wrapper);
	}

}
