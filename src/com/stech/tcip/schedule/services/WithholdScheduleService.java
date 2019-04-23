package com.stech.tcip.schedule.services;

import com.stech.tcip.schedule.dto.ScheduleDTO;

/**
 * 代扣回盘定时任务Serivce
 * @author Aimer
 *
 */
public interface WithholdScheduleService {

	/**
	 * 生成银行批扣文件
	 * @param task
	 * @return
	 */
	String createWithHold(ScheduleDTO task);
	
	/**
	 * @description： 解析银行回盘文件
	 * @param task
	 * @return
	 * @author："geHanBiao"
	 * @crateDate：2018年12月16日下午2:13:04
	 */
	String readBackFile(ScheduleDTO task);
	
}
