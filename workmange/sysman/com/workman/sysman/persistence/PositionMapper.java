package com.workman.sysman.persistence;

import java.util.List;

import com.workman.sysman.model.PositionModel;

public interface PositionMapper {
	List<PositionModel> getPositionList();
	void insert(PositionModel pos);
	void update(PositionModel pos);
	void delete(String code);
	void batchDelete(String[] codes);
}
