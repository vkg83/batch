package com.vkg.catalog.job;

import com.vkg.catalog.model.Product;
import com.vkg.catalog.service.CatalogService;
import com.vkg.catalog.service.CsvDataService;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ReportReader implements ItemReader<Product> {
    private List<Product> items;
    private int counter;
    @Autowired private CsvDataService service;

    @BeforeStep
    public void setup(StepExecution stepExecution) {
        String csvPath = stepExecution.getJobExecution().getExecutionContext().getString("csvPath");
        try {
            loadProducts(csvPath);
        } catch (Exception e) {
            e.printStackTrace();
            items = new ArrayList<>();
        }
        counter = 0;
    }

    private void loadProducts(String csvPath) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(csvPath);
        items = service.read(inputStream);
    }

    @Override
    public Product read() throws Exception {
        if(counter < items.size()) {
            return items.get(counter++);
        }
        return null;
    }
}
