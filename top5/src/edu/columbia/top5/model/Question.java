package edu.columbia.top5.model;

import java.util.List;

public class Question {
	
	String text = "";
	Metadata md = null;
	List<String> answers = null;
	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Metadata getMd() {
		return md;
	}
	public void setMd(Metadata md) {
		this.md = md;
	}
	public List<String> getAnswers() {
		return answers;
	}
	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	
	
	
}
