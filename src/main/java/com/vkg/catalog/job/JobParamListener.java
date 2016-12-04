package com.vkg.catalog.job;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Value;

public class JobParamListener implements JobExecutionListener {
    @Value("${csv.file.path}")
    private String csvPath;
    @Value("${xml.file.path}")
    private String xmlPath;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        jobExecution.getExecutionContext().put("csvPath", csvPath);
        jobExecution.getExecutionContext().put("xmlPath", xmlPath);
    }

    @Override
    public void afterJob(JobExecution jobExecution) {

    }
}
