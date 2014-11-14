//Project class is the root of the program and holds the preferences
//set by the professor about the deadlines and groupsize and so on. 

import java.io.*;
import java.util.ArrayList;

class Project
{
private String projectName;
private String courseNumber;
private String deadline;
private int groupSize;

	Project(String projectName, String courseNumber, String deadLine, int groupSize){
	
	this.projectName = projectName;
	this.courseNumber = courseNumber;
	this.groupSize = groupSize; 
	
	}
	
	String getProjectName()
	{
		return this.projectName;
	}
	
	int getDeadLine()
	{
		return this.projectName;
	}
	
	String getDeadline()
	{
		return this.projectName;
	}
	
	int getGroupSize()
	{
		return this.projectName;
	}
	

}