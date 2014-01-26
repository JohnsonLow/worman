package com.workman.sysman.dao.impl;

import java.util.HashMap;
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
	public ResponseModel getAccountList(Integer level, Integer depCode,
			String name, int page, int size, int currId) {
		ResponseModel res = new ResponseModel();
		AccountWrapper wrapper = new AccountWrapper();
		if (level == null) {
			level = 0;
		}
		if (depCode == null) {
			depCode = 0;
		}
		wrapper.setAuthLevel(level);
		wrapper.setDepCode(depCode);
		wrapper.setCurrId(currId);
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
	public AccountModel getAccount(String userName) {
		return mapper.getAccountByUserName(userName);
	}

	@Override
	public void updateAccount(String name, String phone, int depCode,
			String weibo, int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currId", id);
		map.put("depCode", depCode);
		map.put("weibo", weibo);
		map.put("name", name);
		map.put("phone", phone);
		mapper.updateInfo(map);
	}

	@Override
	public void updatePwd(int id, String password) {
		mapper.updatePwd(id,password);

	}

}
