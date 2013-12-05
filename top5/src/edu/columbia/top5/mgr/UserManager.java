package edu.columbia.top5.mgr;

import java.util.HashMap;
import java.util.Map;

import edu.columbia.top5.model.User;

public enum UserManager {
	INSTANCE;
	
	private Map<String, User> userDb = new HashMap<String, User>();
	
	public void addUser(User u) {
		this.userDb.put(u.getName(), u);
	}
	
	public User authenticate(String un, String pwd) {
		User ans = null;
		if(userDb.containsKey(un)) {
			ans = userDb.get(un);
		}
		return ans;
	}
	
	public void clusterUser(User u) {
		
	}
	
	
	
}
