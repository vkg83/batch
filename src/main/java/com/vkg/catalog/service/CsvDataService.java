package com.vkg.catalog.service;

import com.vkg.catalog.model.Product;
import com.vkg.catalog.model.ProductType;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vinay Gupta on 04-12-2016.
 */
@Service
public class CsvDataService {
    public List<Product> read(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        List<Product> products = new ArrayList<>();
        String line = reader.readLine();
        while (line != null) {
            Product p = adapt(line);
            products.add(p);
            line = reader.readLine();
        }

        return products;
    }

    private Product adapt(String line) {
        String[] words = line.split(",");

        Product p = new Product();
        p.setId(Integer.valueOf(words[0].trim()));
        p.setName(words[1].trim());
        p.setPrice(Double.valueOf(words[2].trim()));
        p.setType(ProductType.valueOf(words[3].trim()));

        return p;
    }
}
