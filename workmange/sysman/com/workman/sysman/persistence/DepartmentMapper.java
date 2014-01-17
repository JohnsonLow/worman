package com.workman.sysman.persistence;

import java.util.List;

import com.workman.sysman.model.DepartmentModel;

public interface DepartmentMapper {
	
	List<DepartmentModel> getDepartmentList();
	
	void insertDepartment(DepartmentModel department);

}
