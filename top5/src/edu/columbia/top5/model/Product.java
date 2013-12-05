package edu.columbia.top5.model;

import java.util.List;

public class Product {
	int id = 0;
	String name = "";
	int [] attributes = new int [9];
	int [] ExpensiveRef = {5, 4, 3, 1, 0};
	
	Product(int ID, List<String> al) {
		id = ID;
		name = al.get(0);
		int price = Integer.parseInt(al.get(2));
		if(price > 0 && price <= 5){
			attributes[0] = ExpensiveRef[price-1]; 
			attributes[1] = ExpensiveRef[5-price];
		}
		String type = al.get(4);
		if(type.equals("Earbud")) {
			attributes[7] += 1;
			attributes[8] += 2;
		}
		else {
			attributes[6] += 2;
			attributes[7] += 1;
			attributes[2] += 2;
			//attributes[8] += 2;
		}
		String soundquality = al.get(6);
		if(soundquality.equals("Excellent")) {
			attributes[3] += 2;			
		}
		else if(soundquality.equals("Very Good")){
			attributes[3] += 1;
		}
		
		String noise = al.get(8);
		if(noise.equals("Excellent")) {
			attributes[3] += 2;			
		}
		else if(noise.equals("Good")){
			attributes[3] += 1;
		}
		
		String design = al.get(7);
		if(design.equals("Closed")) {
			attributes[5] += 2;
		}
		else if(design.equals("Non-Isolating")){
			attributes[4] += 1;
			attributes[5] += 1;
		}
		else {
			attributes[4] += 2;
		}
	}
}
