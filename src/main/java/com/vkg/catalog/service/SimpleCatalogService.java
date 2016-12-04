package com.vkg.catalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vkg.catalog.model.Product;
import com.vkg.catalog.model.ProductType;
import com.vkg.catalog.repo.CatalogDao;

@Service
public class SimpleCatalogService implements CatalogService {
	@Autowired private CatalogDao catalogDao;
	@Value("${file.path}") private String path;
	
	public void add(Product p) {
		catalogDao.add(p);
	}

	public List<Product> findOfType(ProductType type) {
		System.out.println("Service Path: " + path);
		return catalogDao.find(type);
	}

	public void delete(int productId) {
		Product p = new Product();
		p.setId(productId);
		catalogDao.remove(p);
	}

	@Override
	public Product find(int productId) {
		Product p = new Product();
		p.setId(productId);
		return catalogDao.find(p);
	}
}
