package com.vkg.catalog.job;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class ReportWriter implements ItemWriter {
    @Override
    public void write(List list) throws Exception {
        System.out.println("Inside Writer");
    }
}
