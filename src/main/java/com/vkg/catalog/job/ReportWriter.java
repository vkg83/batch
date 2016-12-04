package com.vkg.catalog.job;

import com.vkg.catalog.model.Product;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class ReportWriter implements ItemWriter<Product> {
    @Override
    public void write(List<? extends Product> products) throws Exception {
        System.out.println("Inside Writer");
        products.forEach(System.out::println);
    }
}
