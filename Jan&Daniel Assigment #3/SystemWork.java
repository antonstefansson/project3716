//System holds and returns student informations and school schedules of the students 
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


class SystemWork
{

	public static ArrayList<Student> studentList = new ArrayList<Student>();
	static Student student1 = new Student("Al Capone", "thompsonmachinegun");
	static Student student2 = new Student("Don Corleone", "offerthatyoucannotrefuse");
	static Student student3 = new Student("Carlo Bambino", "bambinofamily");
	static Student student4 = new Student("Richard Kuklinsky", "greatestassasin");
	static Student student5 = new Student("Janet L. Yellen", "currentleaderoffed");
	static Student student6 = new Student("Tony Spilotro", "lasvegasmob");
	//Sample students. 
	
	
	
	public static String loggingIn(String signInName, String password){ 
	
	Student[] studentLogIns = new Student[5];
		
	studentLogIns[0]=student1;
	studentLogIns[1]=student2;
	studentLogIns[2]=student3;
	studentLogIns[3]=student4;
	studentLogIns[4]=student5;
	studentLogIns[5]=student6;
	
	String[] profLogIn = new String[1];
	
	profLogIn[0]="Professor";
	profLogIn[1]="password";

	
	for(int i=0; i<=5; i++){
	
	if(signInName.equals(studentLogIns[i]).getLogInName() && password.equals(studentLogIns[i]).getPassword)
		return "student"; 
	
	if(signInName.equals(profLogIn[0]) && password.equals(profLogIn[1]))
		return "professor"; 
	//Logs in the user.
	
		}
	}
	
	public static ArrayList<Student> getStudentList(){
	studentList.add(student1);
	studentList.add(student2);
	studentList.add(student3);
	studentList.add(student4);
	studentList.add(student5);

	return studentList; 

	}
	
}