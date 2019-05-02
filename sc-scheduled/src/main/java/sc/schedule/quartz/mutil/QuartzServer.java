package sc.schedule.quartz.mutil;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

@Service
public class QuartzServer {

	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;

	public void scheduleJobs() throws SchedulerException {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		startJobTow(scheduler);
		startJobThree(scheduler);
	}

	public void startJobTow(Scheduler scheduler) throws SchedulerException {

		// 定义一个Trigger
		TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
		// 定义name/group
		triggerBuilder.withIdentity("scheduledJobTow", Scheduler.DEFAULT_GROUP);
		triggerBuilder.startNow();// 一旦加入scheduler，立即生效
		triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"));
		// TODO
		// triggerBuilder.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10)
		// // 每隔一秒执行一次
		// .repeatForever()// 一直执行
		//
		// ); // 使用SimpleTrigger
		Trigger trigger = triggerBuilder.build();

		// 定义一个JobDetail
		JobDetail jobDetail = JobBuilder.newJob(ScheduledJobTow.class) // 定义Job类为ScheduledJobTow类，这是真正的执行逻辑所在
				.withIdentity("scheduledJobTow", "scheduledJobTowGroup") // 定义name/group
				.usingJobData("name", "huangjinjin") // 定义属性
				.build();

		scheduler.scheduleJob(jobDetail, trigger);
	}

	public void startJobThree(Scheduler scheduler) throws SchedulerException {
		// 定义一个Trigger
		TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
		// 定义name/group
		triggerBuilder.withIdentity("scheduledJobThree", Scheduler.DEFAULT_GROUP);
		triggerBuilder.startNow();// 一旦加入scheduler，立即生效
		triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"));
		// TODO
		// triggerBuilder.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10)
		// // 每隔一秒执行一次
		// .repeatForever()// 一直执行
		//
		// ); // 使用SimpleTrigger
		Trigger trigger = triggerBuilder.build();

		// 定义一个JobDetail
		JobDetail jobDetail = JobBuilder.newJob(ScheduledJobThree.class) // 定义Job类为ScheduledJobTow类，这是真正的执行逻辑所在
				.withIdentity("scheduledJobThree", "scheduledJobThreeGroup") // 定义name/group
				.usingJobData("age", 30) // 定义属性
				.build();
		scheduler.scheduleJob(jobDetail, trigger);
	}

}
