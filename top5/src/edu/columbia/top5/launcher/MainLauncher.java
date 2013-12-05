package edu.columbia.top5.launcher;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.columbia.top5.mgr.UserManager;
import edu.columbia.top5.model.Question;
import edu.columbia.top5.model.User;

public class MainLauncher {

	private static User user;
	
	public static void main(String[] args) {
		System.out.println("========");
		System.out.println("Welcome to top5 console app");
		System.out.println("========");
		
		boolean logout = false;
		while (!logout) {
			System.out.println("Please select one of the different options: ");
			System.out.println("1. Login");
			System.out.println("2. Create new user");
			System.out.println("3. Search for your top5 Headphones");
			System.out.println("4. Logout");
			
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			
				
			String username = "";
			String password = "";
			
			switch (choice) {
			case 1:
				System.out.println("Username:");
				username = sc.next();
				System.out.println("Password:");
				password = sc.next();
				authenticate(username, password);			
				
				if(user!=null) {
					System.out.println("Hey, thanks for being here. \nHow about answering a couple of questions?");
					askQuestions(5,sc);
				}
				
				break;
			case 2:
				System.out.println("Plase enter de the username:");
				username = sc.next();
				System.out.println("Plase enter a password: ");
				password = sc.next();
				createUser(username, password);
				System.out.println("Let's answer some question to get your profile started:");
				askQuestions(5,sc);
				
				break;
				
			case 3:
				System.out.println("Currently your top5 is:");
				break;
			case 4:
				logout = true;
				break;
				
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
	}
	
	private static void authenticate(String username, String password) {
		user = UserManager.INSTANCE.authenticate(username, password);
		if(user != null) {
			System.out.println("Welcome back " + user.getName());
		}
		else{
			System.out.println("Sorry the user does not exist, try again");
		}
		
	}

	private static void createUser(String uN, String uP) {
		user = new User(uN, uP);
		UserManager.INSTANCE.addUser(user);
	}
	
	
	private static void askQuestions(int nQuestions, Scanner sc) {
		QuestionLauncher ql = null;
		List<Question> questions = null;
		
		ql = new QuestionLauncher(user);
		questions = ql.poseQuestions(nQuestions);
		
		for (Question question : questions) {
			System.out.println(question.getText());
			List<String> options = question.getAnswers();
			for (int i = 0; i < options.size(); i++) {
				System.out.println((i+1)+". " + options.get(i));
			}
			int ans = sc.nextInt();
			user.update(question, ans-1);
		}
		//updateUser with questions
	}
}
