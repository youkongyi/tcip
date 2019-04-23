package com.stech.tcip.schedule.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Select;
import com.stech.tcip.schedule.dto.ScheduleDTO;

/**
 * 定时任务
 * @author Aimer
 *
 */
public interface ScheduleMapper {

	/**
	 * 查询所有定时任务
	 * @return
	 */
	List<ScheduleDTO> queryScheduleTaskForList(ScheduleDTO task);
	
	/**
	 * 更新定时任务
	 * @param task
	 * @return
	 */
	int updateScheduleTask(ScheduleDTO task);
	
	/**
	 * @description：根据机构GID获取应用与分公司代码
	 * @param dataorgid
	 * @return
	 * @author："geHanBiao"
	 * @crateDate：2019年1月17日上午11:26:16
	 */
	@Select("SELECT T.APPID,T2.DATAORGID,T2.ORG_CODE AS ORGCODE FROM T_IP_ACCESSTOKEN T " + 
	        "INNER JOIN T_IP_ORGINFO T2 ON T.DATAORGID=T2.DATAORGID " + 
	        "WHERE T2.DATAORGID=#{dataorgid}")
	Map<String,Object>  queryOrgInfoAppForMap(String dataorgid);
	
}
