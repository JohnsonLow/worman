package com.workman.sysman.persistence;

public interface AuthMapper {
	/*List<AuthModel> getAuthList(int currLevel);
	AuthModel getAuthInfo(int level);
	void insertAuth(AuthModel auth);
	void updateAuth(AuthModel auth);*/
	void batchDelAuth(String[] ids);
	void deleteAuth(String level);
}
