package com.cto51.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CronJob{

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public void execute() {
		log.info("this is Quzrtz cron Job, print time ： "+ System.currentTimeMillis()/1000);
	}

}
