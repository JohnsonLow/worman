package com.workman.sysman.dao;

import java.util.List;

//import com.workman.sysman.model.AuthModel;
import com.workman.sysman.model.DepartmentModel;
import com.workman.sysman.model.PositionModel;

public interface SysmanDao {
	
	/*List<AuthModel> getAuthList(int currLevel);
	AuthModel getAuthInfo(int level);
	boolean addOrUpdateAuth(AuthModel auth);*/
	void deleteAuth(String[] ids);
	
	List<DepartmentModel> getDepartmentList();
	void addOrUpdateDep(DepartmentModel dep);
	void deleteDep(String[] codes);
	
	List<PositionModel> getPositionList();
	void addOrUpdatePos(PositionModel pos);
	void deletePos(String[] codes);
}
