package com.cto51.spring;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListenerSpring implements ServletRequestListener {
	
	private static final Logger logger = LoggerFactory.getLogger(ListenerSpring.class);

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		logger.info("FilterSpring requestDestroyed");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		logger.info("FilterSpring requestInitialized");
	}

}
