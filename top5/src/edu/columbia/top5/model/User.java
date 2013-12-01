package edu.columbia.top5.model;

import java.util.List;

public class User {

	private int[] features;
	private int[] questionCountByFeature;
	private int[] normalizedFeatures;
	private String name = "";
	private String id = "";
	private List<String> tags = null;
	private List<Integer> questionsAnswered = null;
	
	
	
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
	
	
}
