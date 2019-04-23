package com.stech.tcip.schedule.services;

import java.util.List;

import com.stech.tcip.schedule.dto.ScheduleDTO;
import com.stech.tcip.schedule.util.BusinessException;


/**
 * 定时任务Service
 * @author Aimer
 *
 */
public interface ScheduleService {

	/**
	 * 初始化任务
	 * @throws BusinessException
	 */
	void initSchedule() throws BusinessException;
	/**
	 * 向容器中添加任务
	 * @param task
	 * @throws BusinessException
	 */
	void addJob(ScheduleDTO task) throws BusinessException;
	
	/**
	 * 从容器中删除任务
	 * @param jobnames
	 * @throws BusinessException
	 */
	boolean removeJob(List<ScheduleDTO> tasks) throws BusinessException;
	
	/**
	 * 更新容器中任务
	 * @param task
	 * @throws BusinessException
	 */
	void updateJob(ScheduleDTO task) throws BusinessException;
	
	/**
	 * 暂定容器中任务
	 * @return
	 */
	boolean pauseJob(ScheduleDTO task) throws BusinessException;
	
	/**
	 * 暂停容器中所有任务
	 * @return
	 */
	boolean pauseAllJob() throws BusinessException;
	
	/**
	 * 恢复容器中任务
	 * @return
	 * @throws BusinessException
	 */
	boolean resumeJob(ScheduleDTO task) throws BusinessException;
	
	/**
	 * 恢复容器中所有任务
	 * @throws BusinessException
	 */
	boolean resumeAllJob() throws BusinessException;
	
	/**
	 * 判断容器中是否有此任务
	 * @return
	 */
	boolean getScheduleDTO(ScheduleDTO task) throws BusinessException;
	
}
