	
package edu.columbia.top5.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import au.com.bytecode.opencsv.CSV;
import au.com.bytecode.opencsv.CSVReadProc;

public class ProductParser {
	
	static List<Product> pl = null; //Product List
	public static String filename = "resources/ProductReviews.csv";

	private static final CSV csv = CSV
            .separator(',')
            .skipLines(1)
            .charset("UTF-8")
            .create();

	public static List<Product> parseProducts(String fileName) throws IOException{
		pl = new ArrayList<Product>();
		csv.read(fileName, new CSVReadProc() {
			int i = 0;
            public void procRow(int rowIndex, String... values) {
            	List<String>al = Arrays.asList(values);
            	if(al.get(0).equals(""))
            		return;
            	if(al.size() != 25)
            		System.out.println("Product #" + i + " do not have enough information.");
            	i++;
            	Product q = new Product(i, al);
            	pl.add(q);
            }
		});
		return pl;
	}
	

}
