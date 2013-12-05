package edu.columbia.top5.launcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import edu.columbia.top5.model.Question;
import edu.columbia.top5.model.QuestionParser;
import edu.columbia.top5.model.User;

public enum QuestionLauncher {
	INSTANCE;
	
	private User cUser = null;
	private List<Question> availableQuestions = null;
	
	public void init() {
		if(availableQuestions == null) {
			try {
				availableQuestions = QuestionParser.parserQuestions(QuestionParser.filename);
			} catch (IOException e) {
				System.err.println("Error parsing questions for users");
				e.printStackTrace();
			}
		}
		
		
	}

	public List<Question> poseQuestions(User user, int n) {
		
		//CAVEAT: right now if the user has answered all questions we just clear the list and start again
		this.cUser = user;		
		List<Question> tba = new ArrayList<Question>();
		Random r = new Random();
		Set<Integer> used = new HashSet<Integer>();
		int min = 0;
		int max = availableQuestions.size();
		if(max - cUser.getQuestionsAnswered().size() < n ) {
			cUser.getQuestionsAnswered().clear();
		}
		int i=0;
		while( i < n ) {
			int ind = r.nextInt((max - min) + 1) + min;
			if(ind>=0 && ind < max && !used.contains(ind)) {
				Question q = availableQuestions.get(ind);
				used.add(ind);
				if(!cUser.getQuestionsAnswered().contains(q.getId())) {
					tba.add(q);
					i++;	
				}				
			}
		}	
		
		return tba;
	}
	
	
}
