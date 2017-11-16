package com.rueggerllc.jsf20.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class StartupListener implements ServletContextListener {
	
	private static Logger logger = Logger.getLogger(StartupListener.class);
	
	public StartupListener() {
	}
	
	public void contextDestroyed(ServletContextEvent event) {
		logger.info("Context Successfully Destroyed for jsfWAR");
		// CacheManager.getInstance().shutdown();
	}
	
	public void contextInitialized(ServletContextEvent event) {
		logger.info("=== jsfWAR Context Initialization BEGIN ===");
		logger.info("=== jsfWAR Context Initialization END ===");
	}

}
