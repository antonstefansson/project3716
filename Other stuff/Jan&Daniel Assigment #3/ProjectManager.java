//ProjectManager is the UI of the program, it signs people in
//and shows the menu

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


class ProjectManager
{
	public static void main(String[] args) throws IOException{
	
		logIn();
	
	}
	
	static void logIn(){
	
		Scanner scan = new Scanner(System.in);

		System.out.println("Name: ");
     	String logInName = scan.nextLine();
     	
     	System.out.println("Password: ");
     	String password = scan.nextLine();
     	
		
		if(loggingIn(logInName, password).equals("student"))
			studentMenu();
		
		if(loggingIn(logInName, password).equals("professor"))
			profMenu();
		
	}
	
	static void profMenu(){
		System.out.println("Show professor menu");
		//Menu shows methods accessible only to professor.
	}
	
	static void studentMenu(){
		System.out.println("Show student menu");
		//Menu shows methods accessible only to the students.

	}
	
	
}