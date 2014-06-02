package com.ee.concurrency.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedThreadFactory;

/**
 * @author Chris Ritchie
 * 
 * Here we are scheduling the executor to run at its first execution immediately, and every hour thereafter.
 * 
 * This executor will continue to run until you either terminate it, or until an exception it thrown by the task.
 * 
 */
@Stateless
public class ReportBean {

	Logger logger = Logger.getLogger(getClass().getSimpleName());
	
	@Resource(lookup="java:jboss/ee/concurrency/factory/MyManagedThreadFactory")
	private ManagedThreadFactory threadFactory;

	public void runReports() {
		
			ReportTask reportTask = new ReportTask();
			Thread thread = threadFactory.newThread(reportTask);
			logger.log(Level.INFO, "Thread priority : " + thread.getPriority());
			logger.log(Level.INFO, "Starting thread");
			thread.start();
			
	}
}
