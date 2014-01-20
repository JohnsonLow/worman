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
	public boolean addOrUpdateAuth(AuthModel auth) {
		try {
			if(auth.getLevel() != 0){
				authMapper.updateAuth(auth);
			}else{
				authMapper.insertAuth(auth);
			}
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
	public List<PositionModel> getPositionList() {
		return posMapper.getPositionList();
	}

	@Override
	public void deleteAuth(String[] codes) {
		if(codes != null && codes.length > 0){
			if(codes.length == 1){
				authMapper.deleteAuth(codes[0]);
			}else{
				authMapper.batchDelAuth(codes);
			}
			
		}
	}

	@Override
	public void addOrUpdateDep(DepartmentModel dep) {
		if(dep.getCode() != 0){
			depMapper.update(dep);
		}else{
			depMapper.insert(dep);
		}
		
	}

	@Override
	public void deleteDep(String[] ids) {
		if(ids != null && ids.length > 0){
			if(ids.length == 1){
				depMapper.delete(ids[0]);
			}else{
				depMapper.batchDelete(ids);
			}
		}
		
	}

	@Override
	public void addOrUpdatePos(PositionModel pos) {
		if(pos.getCode() == 0){
			posMapper.insert(pos);
		}else{
			posMapper.update(pos);
		}
		
	}

	@Override
	public void deletePos(String[] codes) {
		if(codes != null && codes.length > 0){
			if(codes.length == 1){
				posMapper.delete(codes[0]);
			}else{
				posMapper.batchDelete(codes);
			}
		}
		
	}

}
