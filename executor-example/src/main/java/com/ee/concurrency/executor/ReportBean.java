package com.ee.concurrency.executor;

import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;

/**
 * @author Chris Ritchie
 */
@Stateless
public class ReportBean {

	Logger logger = Logger.getLogger(getClass().getSimpleName());
	
	@Resource
	private ManagedExecutorService executorService;

	public void runReports() {
		
		ReportTask reportTask = new ReportTask();
		logger.log(Level.INFO, "Calling managed executor service");
		Future<Report> future = executorService.submit(reportTask);
		logger.log(Level.INFO, "Successfully called managed executor service");
		
	}

}
