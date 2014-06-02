package com.ee.concurrency.executor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Chris Ritchie
 */
public class ReportTask implements Runnable {

	Logger logger = Logger.getLogger(getClass().getSimpleName());
	
	public void run() {
		
		try {
			//do your background task
			Thread.sleep(10000);  //10 seconds
		} catch (InterruptedException e) {
			logger.log(Level.SEVERE, "Thread interrupted", e);
		}
	}

}
