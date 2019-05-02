package sc.schedule.quartz;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

//@Configuration
public class QuartzScheduledOne {

	@Bean
	public ScheduledJobOne getScheduledJobOne() {
		return new ScheduledJobOne();
	}

	/**
	 * 调度工厂
	 * 
	 * @param jobTrigger
	 *            触发器
	 * @return
	 */
	@Bean(name = "scheduler")
	public SchedulerFactoryBean schedulerFactory(Trigger jobTrigger) {
		SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
		// 用于quartz集群,QuartzScheduler 启动时更新己存在的Job
		factoryBean.setOverwriteExistingJobs(true);
		// 延时启动，应用启动1秒后
		factoryBean.setStartupDelay(1);
		// 注册触发器
		factoryBean.setTriggers(jobTrigger);
		return factoryBean;
	}

	/**
	 * 
	 * 定时触发器
	 * 
	 * @param reptilianJob
	 *            任务
	 * 
	 * @return
	 * 
	 */
	@Bean(name = "jobTrigger")
	public CronTriggerFactoryBean cronJobTrigger(JobDetail jobDetail) {
		CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();
		tigger.setJobDetail(jobDetail);
		// cron表达式，每1分钟执行一次
		tigger.setCronExpression("0/20 * * * * ?");
		tigger.setName("jobTrigger");
		return tigger;
	}

	/**
	 * 配置任务
	 * 
	 * @param quartzTask
	 *            QuartzTask为需要执行的任务
	 * @return
	 */
	@Bean(name = "jobDetail")
	public MethodInvokingJobDetailFactoryBean detailFactoryBean(ScheduledJobOne quartzTask) {
		MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
		// 是否并发执行
		jobDetail.setConcurrent(false);
		// 设置任务的名字
		jobDetail.setName("jobDetail");
		// 设置任务的分组，在多任务的时候使用
		jobDetail.setGroup("jobDetailGroup");
		// 需要执行的对象
		jobDetail.setTargetObject(quartzTask);
		/*
		 * TODO非常重要 执行QuartzTask类中的需要执行方法
		 */
		jobDetail.setTargetMethod("execute");
		return jobDetail;
	}

}
