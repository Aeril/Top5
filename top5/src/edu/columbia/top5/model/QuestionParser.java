package edu.columbia.top5.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import au.com.bytecode.opencsv.CSV;
import au.com.bytecode.opencsv.CSVReadProc;

public class QuestionParser {
	
	static List<Question> ql = null; //Question List
	public static String filename = "resources/ProductReviews.csv";

	private static final CSV csv = CSV
            .separator(',')
            .skipLines(1)
            .charset("UTF-8")
            .create();

	public static List<Question> parserQuestions(String fileName) throws IOException{
		ql = new ArrayList<Question>();
		csv.read(fileName, new CSVReadProc() {
            public void procRow(int rowIndex, String... values) {
            	List<String>al = Arrays.asList(values);
            	if(al.get(0).equals(""))
            		return;
            	if(al.size() != 34)
            		System.out.println("Question #" + al.get(0) + " do not have enough information.");
            	Question q = new Question(al);
            	ql.add(q);
            }
		});
		return ql;
	}
	
}
