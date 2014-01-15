package com.workman.sysman.persistence;

import java.util.List;

import com.workman.sysman.model.AuthModel;

public interface AuthMapper {
	List<AuthModel> getAuthList();
	AuthModel getAuthInfo(int level);
}
