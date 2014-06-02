package com.ee.concurrency.executor;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Chris Ritchie
 */
public class ReportTask implements Callable<Report> {

	Logger logger = Logger.getLogger(getClass().getSimpleName());
	
	public Report call() {
		
		int priority = Thread.currentThread().getPriority();
		logger.log(Level.INFO, "Thread Priority is: " + priority);
		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			logger.log(Level.SEVERE, "Thread interrupted", e);
//		}
//		
		logger.log(Level.INFO, "Report task has finished");
		
		return new Report();
	}

}
