package edu.columbia.top5.model;

import java.util.HashMap;
import java.util.List;

public class Group {
	
	private HashMap<String, List<User>> clusters;
	private List<Product> products;
	
	
	public HashMap<String, List<User>> getClusters() {
		return clusters;
	}
	public void setClusters(HashMap<String, List<User>> clusters) {
		this.clusters = clusters;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	

}
