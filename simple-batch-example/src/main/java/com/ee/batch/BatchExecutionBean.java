package com.ee.batch;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
import javax.ejb.Stateless;
import java.util.Properties;

/**
 * Payroll for contractors. Read in all logged hours, and pay acording to hourly
 * rate
 * 
 * @author chris
 * @see "http://www.oracle.com/technetwork/articles/java/batch-1965499.html"
 */
@Stateless
public class BatchExecutionBean {

	public long submitJob() {
		JobOperator jobOperator = BatchRuntime.getJobOperator();
		Properties jobProperties = new Properties();
		long executionId = jobOperator.start("planetjones-test-batch-job",
				jobProperties);
		return executionId;
	}

	public JobExecution getJobExecutionDetails(long executionId) {
		JobOperator jobOperator = BatchRuntime.getJobOperator();
		JobExecution jobExecution = jobOperator.getJobExecution(executionId);
		return jobExecution;
	}

	public long restartJob(long executionId) {
		Properties jobProperties = new Properties();
		long newExecutionId = BatchRuntime.getJobOperator().restart(
				executionId, jobProperties);
		return newExecutionId;
	}

}
