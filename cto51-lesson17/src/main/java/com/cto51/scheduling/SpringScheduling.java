package com.cto51.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SpringScheduling {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	private int runTimes = 0;
	
	private int dispatchTimes = 0;
	
	@Scheduled(cron="*/5 * * * * ?")
	public void redPacket(){
		log.info("start time : " + System.currentTimeMillis()/1000);
		runTimes = runTimes+1;
		log.info("第"+runTimes+"次派红包");
	}
	
	@Scheduled(fixedRate=10000)
	public void dispatchMenoy(){
		log.info("start time : " + System.currentTimeMillis()/1000);
		dispatchTimes = dispatchTimes+1;
		log.info("第"+dispatchTimes+"次发钱");
	}

}
