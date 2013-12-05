package edu.columbia.top5.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Question {
	
	int id = 0; 
	String text = "";
	//Metadata md = null;
	List<String> answers = null;
	HashMap <String, int[]> answersAttr = null;
	int featureNumber = 9;
	
	public Question (List<String> al) {
		id = Integer.parseInt(al.get(0));
		text = al.get(1);
		answers = new ArrayList <String>();
		answersAttr = new HashMap<String, int[]> ();
		int p = 2;
		for(int i = 0; ; i++) {
			//System.out.println(i);
			p = 2 + i * (1 + featureNumber);
			//System.out.println(p);
			
			if(p < al.size() - 1 && !al.get(p).equals("-") && !al.get(p).equals("Skip Question")) {
				answers.add(al.get(p));
				//System.out.println(al.get(p));
				int [] eachAnswerAttr = new int[featureNumber];
				for(int j = 0; j < featureNumber; j++) {
					try {
					eachAnswerAttr[j] = Integer.parseInt(al.get(p+j+1));
					}
					catch (NumberFormatException e){
						System.out.println("Question #" + id + " has problem with column " + p + j + 1);
					}
				}
				answersAttr.put(al.get(p), eachAnswerAttr);
			}
			else break;
			//System.out.println(i);
		}
		
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<String> getAnswers() {
		return answers;
	}
	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
