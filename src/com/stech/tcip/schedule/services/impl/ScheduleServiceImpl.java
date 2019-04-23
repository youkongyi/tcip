package com.stech.tcip.schedule.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import com.stech.tcip.schedule.dao.ScheduleMapper;
import com.stech.tcip.schedule.dto.ScheduleDTO;
import com.stech.tcip.schedule.services.ScheduleService;
import com.stech.tcip.schedule.util.BusinessException;
import com.stech.tcip.schedule.util.ScheduleConstants;
import com.stech.tcip.schedule.util.ScheduleJobs;
import com.stech.tcip.schedule.util.StringUtils;

/**
 * 定时任务Service
 * @author Aimer
 *
 */
@Component
public class ScheduleServiceImpl implements ScheduleService {

	private static final Logger logger = LogManager.getLogger(ScheduleServiceImpl.class);
	
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	
	@Autowired
	private ScheduleMapper scheduleMapper;
	
	/**
	 * 初始化任务
	 * @throws BusinessException 
	 */
	@Override
	public void initSchedule() throws BusinessException {
		try {
			logger.info("初始化任务开始... ");
			ScheduleDTO task = new ScheduleDTO();
			// 周期性
             task.setType(ScheduleConstants.SCHEDULE_TYPE_AUTO);
            // 未运行
            // task.setStatus(ScheduleConstants.SCHEDULE_STATE_OFF);
			// 获取任务列表
			List<ScheduleDTO> tasks  = scheduleMapper.queryScheduleTaskForList(task);
			for(ScheduleDTO ScheduleDTO : tasks) {
				// 添加任务
				this.addJob(ScheduleDTO);
			}
			logger.info("初始化任务结束... ");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("初始化定时任务失败: "+e);
			throw new BusinessException("ScheduleServiceImpl.initSchedule", "初始化任务失败");
		}
	}
	
	
	/**
	 * 添加新任务
	 */
	@Override
	public void addJob(ScheduleDTO task) throws BusinessException {
	    String key = this.getKey(task);
		logger.info("添加任务: "+key);
		try {
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			// 任务构建withIdentity:相当于给任务起了个名字
			JobDetail jobDetail = JobBuilder.newJob(ScheduleJobs.class).withIdentity(new JobKey(key,task.getTcisCode())).build();
			jobDetail.getJobDataMap().put("task", task);
			// 表达式调度构建器
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(task.getExportCron());
			// 按新的cronExpression表达式构建一个新的trigger：withIdentity:相当于给trigger起了个名字
			CronTrigger cronTrigger = TriggerBuilder.newTrigger().withSchedule(scheduleBuilder).withIdentity(new TriggerKey(key,task.getTcisCode())).build();
			// 创建任务
			scheduler.scheduleJob(jobDetail, cronTrigger);
			// 运行开始
			task.setStartTime(ScheduleConstants.SCHEDULE_START);
			task.setName(null);
			task.setType(null);
			task.setExportCron(null);
			//更新任务
			scheduleMapper.updateScheduleTask(task);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new BusinessException("ScheduleServiceImpl.addJob", (task.getName()+"@"+task.getId())+":quartz添加job异常");
		}
	}

	/**
	 * 删除任务
	 */
	@Override
	public boolean removeJob(List<ScheduleDTO> tasks) throws BusinessException {
		logger.info("删除定时任务 :"+ tasks.size());
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		try {
			for(ScheduleDTO task: tasks){
			    //任务key
			    String key = this.getKey(task);
				// 停止触发器
				scheduler.pauseTrigger(new TriggerKey(key,task.getTcisCode()));
				//移除触发器
				scheduler.unscheduleJob(new TriggerKey(key,task.getTcisCode()));
				//删除任务 
				scheduler.deleteJob(new JobKey(key,task.getTcisCode()));
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new BusinessException("ScheduleServiceImpl.removeJob", tasks+"：quartz删除job异常");
		}
	}


	/**
	 * 判断容器中是否有此任务
	 */
	@Override
	public boolean getScheduleDTO(ScheduleDTO task) throws BusinessException {
		//任务key
	    String key = this.getKey(task);
		try {
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			//获取trigger实例
			TriggerKey triggerKey = TriggerKey.triggerKey(key, task.getTcisCode());
			Trigger trigger = scheduler.getTrigger(triggerKey);
			if(StringUtils.isNotNull(trigger)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new BusinessException("ScheduleServiceImpl.getScheduleDTO", "获取任务失败");
		}
		return false;
	}


	/**
	 * 暂定容器中任务
	 */
	@Override
	public boolean pauseJob(ScheduleDTO task) throws BusinessException {
	    //任务key
        String key = this.getKey(task);
		try {
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			JobKey jobKey = JobKey.jobKey(key, task.getTcisCode());
			// 暂停触发器
			scheduler.pauseTrigger(TriggerKey.triggerKey(key, task.getTcisCode()));
			scheduler.pauseJob(jobKey);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new BusinessException("ScheduleServiceImpl.pauseJob", "暂定任务失败");
		}
	}

	/**
	 * 暂停所有任务
	 */
	@Override
	public boolean pauseAllJob() throws BusinessException {
		try {
			schedulerFactoryBean.getScheduler().pauseAll();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new BusinessException("ScheduleServiceImpl.pauseAllJob", "暂停任务失败");
		}
		return true;
	}


	/**
	 * 恢复容器中任务
	 */
	@Override
	public boolean resumeJob(ScheduleDTO task) throws BusinessException {
		//任务key
	    String key = this.getKey(task);
		JobKey jobKey = JobKey.jobKey(key, task.getTcisCode());
		try {
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			// 恢复触发器
			scheduler.resumeTrigger(TriggerKey.triggerKey(key, task.getTcisCode()));
			scheduler.resumeJob(jobKey);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new BusinessException("ScheduleServiceImpl.resumeJob", "恢复容器中任务");
		}
	}

	/**
	 * 恢复容器中所有任务
	 */
	@Override
	public boolean resumeAllJob() throws BusinessException {
		try {
			schedulerFactoryBean.getScheduler().resumeAll();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw new BusinessException("ScheduleServiceImpl.resumeAllJob", "暂定任务失败");
		}
	}


    @Override
    public void updateJob(ScheduleDTO task) throws BusinessException {
    }
    
    /**
     * @description： 获取任务key: 
     *                       任务id+名称+银行代码+tcis服务代码+机构id+分公司id
     * @return
     * @author："geHanBiao"
     * @crateDate：2018年12月28日上午9:22:16
     */
    private String getKey(ScheduleDTO task) {
        StringBuffer key = new StringBuffer();
        key.append(task.getId());
        key.append(task.getName());
        key.append(task.getBankCode());
        key.append(task.getTcisCode());
        key.append(task.getDataorgid());
        return key.toString();
    }
    
}
