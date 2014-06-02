package com.ee.concurrency.executor;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;

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
	
	@Resource(lookup="java:jboss/ee/concurrency/scheduler/MyScheduledExectutorService")
	private ManagedScheduledExecutorService executorService;

	public void runReports() {
		
		ReportTask reportTask = new ReportTask();
		logger.log(Level.INFO, "Calling managed executor service");
		executorService.scheduleAtFixedRate(reportTask, 0L, 1L, TimeUnit.HOURS);
		logger.log(Level.INFO, "Successfully called managed executor service");
	}

}
