package com.yash.training.rest.database;

import java.util.HashMap;
import java.util.Map;

import com.yash.training.rest.model.Product;

public class ProductDataBaseClass {
	
	private static Map<Integer, Product> products=new HashMap<>();

	public static Map<Integer, Product> getProducts() {
		return products;
	}

}
