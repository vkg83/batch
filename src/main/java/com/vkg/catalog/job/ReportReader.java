package com.vkg.catalog.job;

import com.vkg.catalog.service.CatalogService;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

public class ReportReader implements ItemReader<String> {
    private String[] items = {"a", "b", "c"};
    private int counter;
    @Autowired private CatalogService service;

    @BeforeStep
    public void setup() {
        counter = 0;
    }
    @Override
    public String read() throws Exception {
        System.out.println("Reader's service: " + service);
        if(counter < items.length) {
            return items[counter++];
        }
        return null;
    }
}
