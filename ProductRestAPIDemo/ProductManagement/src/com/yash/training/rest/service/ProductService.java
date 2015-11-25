package com.yash.training.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yash.training.rest.database.ProductDataBaseClass;
import com.yash.training.rest.model.Product;

public class ProductService {
	
	private Map<Integer, Product> products=ProductDataBaseClass.getProducts();
	
	public ProductService() {
		// create model
				Product p1=new Product(1, "Laptop", "Core i5 Intel Processor", "HP");
				Product p2=new Product(2, "Projector", "projector for Seminar Hall", "NEC");
				products.put(1, p1);
				products.put(2, p2);
	}

	public List<Product> getAllProducts() {			
		return new ArrayList<Product>(products.values());
	}

	public Product getProduct(int productId) {
		return products.get(productId);
	}

	public Product addProduct(Product product) {
		int id=products.size()+1;
		product.setId(id);
		products.put(product.getId(), product);
		return products.get(product.getId());
	}

	public Product updateProduct(Product product) {
		return products.put(product.getId(), product);
	}

	public void removeProduct(int productId) {
		products.remove(productId);
		
	}
	

}
