package edu.columbia.top5.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

	int featureNumber = 9;
	private int[] features = new int[featureNumber];
	private int[] questionCountByFeature;
	private int[] normalizedFeatures;
	private String name = "";
	private String id = "";
	private String password = "";
	private List<String> tags = null;
	private List<Integer> questionsAnswered = new ArrayList<Integer>();
	
	
	public User(String username, String password) {
		this.name = username;
		this.password = password;
	}
	
	public int[] getFeatures() {
		return features;
	}
	public void setFeatures(int[] features) {
		this.features = features;
	}
	public int[] getQuestionCountByFeature() {
		return questionCountByFeature;
	}
	public void setQuestionCountByFeature(int[] questionCountByFeature) {
		this.questionCountByFeature = questionCountByFeature;
	}
	public int[] getNormalizedFeatures() {
		return normalizedFeatures;
	}
	public void setNormalizedFeatures(int[] normalizedFeatures) {
		this.normalizedFeatures = normalizedFeatures;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public List<Integer> getQuestionsAnswered() {
		return questionsAnswered;
	}
	public void setQuestionsAnswered(List<Integer> questionsAnswered) {
		this.questionsAnswered = questionsAnswered;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public void addQuestion(int i) {
		this.questionsAnswered.add(i);
	}
	
	public void update(Question q, int option) {
		String ans = q.getAnswers().get(option);
		int[] update = q.answersAttr.get(ans);		
		updateFeatureVectors(update);
		this.questionsAnswered.add(q.getId());
	}
	
	private void updateFeatureVectors(int[] newFeats) {
		System.out.println("Updating with...");
		System.out.println(Arrays.toString(newFeats));
		
		System.out.println("before");
		System.out.println(Arrays.toString(this.features));
		for (int i = 0; i < newFeats.length; i++) {
			this.features[i] += newFeats[i];			
		}
		System.out.println(Arrays.toString(this.features));
		
	}
	
}
