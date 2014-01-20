package com.workman.sysman.persistence;

import java.util.List;

import com.workman.sysman.model.DepartmentModel;

public interface DepartmentMapper {
	
	List<DepartmentModel> getDepartmentList();
	
	void insert(DepartmentModel department);

	void update(DepartmentModel dep);

	void delete(String code);

	void batchDelete(String[] codes);

}
