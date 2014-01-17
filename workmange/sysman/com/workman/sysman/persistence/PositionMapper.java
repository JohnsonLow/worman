package com.workman.sysman.persistence;

import java.util.List;

import com.workman.sysman.model.PositionModel;

public interface PositionMapper {
	List<PositionModel> getPositionList();
	void insertPosition(PositionModel pos);
}
