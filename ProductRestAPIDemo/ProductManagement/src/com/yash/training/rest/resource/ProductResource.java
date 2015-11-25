package com.yash.training.rest.resource;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.yash.training.rest.model.Product;
import com.yash.training.rest.service.ProductService;

@Path("/products")
public class ProductResource {
	
	ProductService productService=new ProductService();
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}	
	@GET
	@Path("/{productId}")
	@Produces(MediaType.APPLICATION_XML)
	public Product getProduct(@PathParam("productId") int productId){
		return productService.getProduct(productId);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Product addProduct(Product product){
		return productService.addProduct(product);
	}
	
	@PUT
	@Path("/{productId}")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Product updateProduct(@PathParam("productId") int productId,Product product){
		product.setId(productId);
		return productService.updateProduct(product);
	}
	
	@DELETE
	@Path("/{productId}")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public void deleteProduct(@PathParam("productId") int productId){
		
		productService.removeProduct(productId);
		
	}

}
