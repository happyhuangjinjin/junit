package sc.schedule.quartz.mutil;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzScheduled {
	
	@Autowired
	private QuartzServer quartzServer;

	/**
	 * 模拟启动任务
	 * 
	 * @return
	 */
	@Bean
	public Object startJobs(){
		try {
			quartzServer.scheduleJobs();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return new Object();
	}
	
	@Autowired
	private CustomJobFactory customJobFactory;

	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		// 将job实例化，能够操作进行Spring注入
		schedulerFactoryBean.setJobFactory(customJobFactory);
		return schedulerFactoryBean;
	}
}
