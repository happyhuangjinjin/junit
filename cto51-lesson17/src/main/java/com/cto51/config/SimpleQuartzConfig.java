package com.cto51.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cto51.quartz.SimpleQuartzJob;

@Configuration
public class SimpleQuartzConfig {

	@Bean
	public JobDetail getJobDetail() {
	        return JobBuilder.newJob(SimpleQuartzJob.class)
	        		.withIdentity("SimpleQuartzJob")
	                .usingJobData("name", "公众号 聊点")
	                .storeDurably()
	                .build();
	 }

    @Bean
    public Trigger getTrigger(JobDetail jobDetail) {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder
        		.simpleSchedule()
                .withIntervalInSeconds(5) //间隔5秒
                .repeatForever();
        
        Trigger trigger= TriggerBuilder
				.newTrigger()
				.forJob(jobDetail)
		        .withIdentity("SampleTrigger")
		        .withSchedule(scheduleBuilder)
		        .build();
        return trigger;
    }
	
}
