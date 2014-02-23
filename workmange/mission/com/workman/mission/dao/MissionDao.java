package com.workman.mission.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.workman.commons.po.ResponseModel;
import com.workman.mission.model.MissionHandleModel;
import com.workman.mission.model.MissionModel;

public interface MissionDao {
	/**
	 * 根据id获取任务的相关信息
	 * @param missionId
	 * @return
	 */
	MissionModel getMission(int missionId);
	/**
	 * 创建任务
	 * @param mission
	 */
	void create(MissionModel mission);
	/**
	 * 处理任务
	 * @param handel
	 */
	void handle(MissionHandleModel handel);
	/**
	 * 完成任务
	 * @param missionId
	 */
	void commitMission(int missionId);
	
	
	/**
	 * 
	 * @param handler 查询用户id
	 * @param status 任务状态
	 * @param type 任务紧急程度
	 * @param startDate 任务创建时间的 上限
	 * @param endDate 任务创建时间的  下限
	 * @param id 任务id
	 * @param searchType 搜索类型  2为我发起的任务 3为我处理过的任务
	 * @param page 页码
	 * @param size 每页条数
	 * @return
	 * @throws Exception
	 */
	ResponseModel getMissions(int handler,Integer status, String type,
			Date startDate, Date endDate, Integer id,int searchType, int page, int size) throws Exception;
	
	/**
	 * 获得待处理任务
	 * @param handlerId
	 * @return
	 */
	List<Map<String,Object>> getMissions(Integer handlerId) throws Exception ;
	/**
	 * 更新该任务的受理时间
	 * @param missionId
	 */
	void updateHandTime(int missionId);
	
	public List<MissionHandleModel> getMissionHandles(int missionId) ;
	
	public MissionHandleModel getMissionHandle(int handleId);
}
