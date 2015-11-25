package com.yash.training.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
	
	private int id;
	private String name;
	private String description;
	private String vendor;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String name, String description, String vendor) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.vendor = vendor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	

}
