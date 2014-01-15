package com.workman.sysman.dao;

import java.util.List;

import com.workman.sysman.model.AuthModel;

public interface AuthDao {
	
	List<AuthModel> getAuthList();
	AuthModel getAuthInfo(int level);

}
