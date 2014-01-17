package com.workman.sysman.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workman.commons.util.SysLogUtils;
import com.workman.sysman.dao.SysmanDao;
import com.workman.sysman.model.AuthModel;
import com.workman.sysman.model.DepartmentModel;
import com.workman.sysman.model.PositionModel;
import com.workman.sysman.persistence.AuthMapper;
import com.workman.sysman.persistence.DepartmentMapper;
import com.workman.sysman.persistence.PositionMapper;

@Service
public class SysmanDaoImpl implements SysmanDao{
	
	@Autowired
	private AuthMapper authMapper;
	@Autowired
	private DepartmentMapper depMapper;
	@Autowired
	private PositionMapper posMapper;
	@Override
	public List<AuthModel> getAuthList() {
		return authMapper.getAuthList();
	}

	@Override
	public AuthModel getAuthInfo(int level) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertAuth(AuthModel auth) {
		try {
			authMapper.insertAuth(auth);
			return true;
		} catch (Exception e) {
			SysLogUtils.error(SysmanDaoImpl.class, e, "插入权限信息出错");
			return false;
		}
	}

	@Override
	public List<DepartmentModel> getDepartmentList() {
		return depMapper.getDepartmentList();
	}

	@Override
	public boolean insertDepartment(DepartmentModel dep) {
		try {
			depMapper.insertDepartment(dep);
			return true;
		} catch (Exception e) {
			SysLogUtils.error(SysmanDaoImpl.class, e, "插入部门信息出错");
			return false;
		}
	}

	@Override
	public List<PositionModel> getPositionList() {
		return posMapper.getPositionList();
	}

	@Override
	public boolean insertPosition(PositionModel pos) {
		try {
			posMapper.insertPosition(pos);
			return true;
		} catch (Exception e) {
			SysLogUtils.error(SysmanDaoImpl.class, e, "插入职位信息出错");
			return false;
		}
	}

}
