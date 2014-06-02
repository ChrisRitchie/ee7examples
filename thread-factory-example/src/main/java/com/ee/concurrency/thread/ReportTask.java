package com.ee.concurrency.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Chris Ritchie
 */
public class ReportTask implements Runnable {

	Logger logger = Logger.getLogger(getClass().getSimpleName());
	
	public void run() {
		
		logger.log(Level.INFO, "New thread running...");
		
		try {
			//do your background task
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			logger.log(Level.SEVERE, "Thread interrupted", e);
		}
		
		logger.log(Level.INFO, "Task coming to end...");
		
	}

}
