package com.workman.sysman.dao;

import java.util.List;

import com.workman.sysman.model.AuthModel;
import com.workman.sysman.model.DepartmentModel;
import com.workman.sysman.model.PositionModel;

public interface SysmanDao {
	
	List<AuthModel> getAuthList();
	AuthModel getAuthInfo(int level);
	boolean addOrUpdateAuth(AuthModel auth);
	
	List<DepartmentModel> getDepartmentList();
	boolean insertDepartment(DepartmentModel dep);
	
	List<PositionModel> getPositionList();
	boolean insertPosition(PositionModel pos);
	void deleteAuth(String[] ids);
}
