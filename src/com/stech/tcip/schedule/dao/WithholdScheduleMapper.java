/*
 * 珠海卓锐公司源代码，版权归卓锐公司所有。
 * 创建日期 : 2018年12月18日
 * 修改历史 : 
 *     1. [2018年12月18日]创建文件 by "geHanBiao"
 */
package com.stech.tcip.schedule.dao;

import java.util.List;

import com.stech.tcip.schedule.dto.BankSchedule;
import com.stech.tcip.schedule.dto.ScheduleDTO;
import com.stech.tcip.schedule.dto.WithholdSchedule;

/**
 * 
 * @author "geHanBiao"
 * @version 2018年12月18日
 */
public interface WithholdScheduleMapper {
    
    /**
     * @description： 添加方法功能描述
     * @param task
     * @return
     * @throws BusinessException
     * @author："geHanBiao"
     * @crateDate：2018年12月18日下午6:29:30
     */
    WithholdSchedule queryWithholdScheduleTask(ScheduleDTO task);
    
    /**
     * @description： 添加方法功能描述
     * @param bankSchedule
     * @return
     * @author："geHanBiao"
     * @crateDate：2018年12月18日下午6:46:57
     */
    boolean insertBankSchedule(BankSchedule bankSchedule);
    
    /**
     * @description： 添加方法功能描述
     * @param bankSchedule
     * @return
     * @author："geHanBiao"
     * @crateDate：2018年12月18日下午10:05:00
     */
    List<BankSchedule> queryBankFileName(ScheduleDTO bankSchedule);
    
    /**
     * @description： 添加方法功能描述
     * @param bankSchedule
     * @return
     * @author："geHanBiao"
     * @crateDate：2018年12月18日下午10:20:38
     */
    boolean updateBankSchedule(BankSchedule bankSchedule);
}
