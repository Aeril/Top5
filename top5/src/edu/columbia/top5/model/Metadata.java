package edu.columbia.top5.model;

import java.util.ArrayList;

public class Metadata {

	private int questionID;
	private int numberAnsers = 0;
	private ArrayList <int[]> attributeModifier;
	private String tag ="";
	
	
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public int getNumberAnsers() {
		return numberAnsers;
	}
	public void setNumberAnsers(int numberAnsers) {
		this.numberAnsers = numberAnsers;
	}
	public ArrayList<int[]> getAttributeModifier() {
		return attributeModifier;
	}
	public void setAttributeModifier(ArrayList<int[]> attributeModifier) {
		this.attributeModifier = attributeModifier;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
}
