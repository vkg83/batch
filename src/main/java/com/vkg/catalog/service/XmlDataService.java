package com.vkg.catalog.service;

import com.vkg.catalog.model.Product;
import com.vkg.catalog.model.ProductType;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vinay Gupta on 04-12-2016.
 */
@Service
public class XmlDataService {
    public void write(OutputStream outputStream, List<? extends Product> products) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        for (Product p : products) {
            writer.write(adapt(p));
        }

    }

    private String adapt(Product p) {
        String str = createTag("product",
                createTag("id", p.getId().toString())
                + createTag("name", p.getName())
                + createTag("price", p.getPrice().toString())
                + createTag("type", p.getType().toString())
                );

        return str;
    }

    private String createTag(String tagName, String body) {
        return '<' + tagName + '>' + body + "</" + tagName + '>';
    }
}
