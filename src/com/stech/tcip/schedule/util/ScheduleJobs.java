package com.stech.tcip.schedule.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import static com.stech.tcip.schedule.util.ScheduleConstants.SCHEDULE_SEARCH_TYPE_SERVICE_2008;
import static com.stech.tcip.schedule.util.ScheduleConstants.SCHEDULE_SEARCH_TYPE_SERVICE_2009;

import com.stech.tcip.schedule.dao.ScheduleMapper;
import com.stech.tcip.schedule.dto.ScheduleDTO;
import com.stech.tcip.schedule.services.WithholdScheduleService;

/**
 * 定时任务运行工厂类
 * @author Aimer
 *
 */
@DisallowConcurrentExecution
public class ScheduleJobs implements Job {

    private static final Logger logger = LogManager.getLogger(ScheduleJobs.class);

    @Autowired
    private ScheduleMapper scheduleMapper;
    
    @Autowired
    private WithholdScheduleService withholdScheduleService;
    
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            ScheduleDTO task = (ScheduleDTO) context.getJobDetail().getJobDataMap().get("task");
            System.out.println(task);
            //检索类型一致调用逻辑
             if(SCHEDULE_SEARCH_TYPE_SERVICE_2008.equals(task.getTcisCode())){
                 String ret = withholdScheduleService.createWithHold(task);
                 logger.info(ret);    
             }
             if(SCHEDULE_SEARCH_TYPE_SERVICE_2009.equals(task.getTcisCode())){
                 scheduleMapper.updateScheduleTask(task);
                 String ret = withholdScheduleService.readBackFile(task);
                 logger.info(ret);
             }
             // 运行次数+1
             task.setRunTime(ScheduleConstants.SCHEDULE_END);
             // 运行完成
             task.setStatus(ScheduleConstants.SCHEDULE_STATE_END);
             scheduleMapper.updateScheduleTask(task);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
    }
    

}
