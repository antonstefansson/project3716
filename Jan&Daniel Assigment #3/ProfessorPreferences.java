//This class is only accessible by the Professor and lets
//him set the project up, but also it allows him to view the groups. 


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class ProfessorPreferences 
{
	public static void setUpProject() throws IOException {
	
	Scanner scan = new Scanner(System.in);
	
	System.out.println("What course is this for?");
     String courseNumber = scan.nextLine();
	
	System.out.println("What is the name of this project?");
     String name = scan.nextLine();
	
	System.out.println("When is the deadline?");
     String deadline = scan.nextLine();
     	
	System.out.println("What is the group size?"); 
     int size = scan.nextInt();
	
	Project project = new Project(name, courseNumber,deadline,size); 
	//A new project is created.
	
	}
	
	public static void viewGroups(){
	
	int size = GroupCreator.groups.size();
	
	int i;
		
	for(i=0; i<size; i++){
	
	System.out.println("Here is group number " + i + " : " +
	GroupCreator.groups.get(i).GroupCreator.group.get(i).Student.getLogInName() +
	" and " + Student.groups.get(i).GroupCreator.group.get(i+1).Student.getLogInName());
	
	if(Project.getGroupsize < 2)//if statement for groups bigger than 2 people. 
	{
		for(int n=0; n<(Project.getGroupsize()-2); n++){
		System.out.println(" and " + Student.groups.get(i).GroupCreator.group.get(n).Student.getLogInName());
		}
	}
	}
	
	}
}