package com.vkg.catalog.job;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Value;

public class JobParamListener implements JobExecutionListener {
    @Value("${file.path}")
    private String path;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("Before job");
        System.out.println("Path: " + path);
    }

    @Override
    public void afterJob(JobExecution jobExecution) {

    }
}
