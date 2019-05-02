package com.cto51.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class SimpleQuartzJob extends QuartzJobBean {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		log.info("this is Quzrtz Job, print time ： "+ System.currentTimeMillis()/1000);
	}

}
