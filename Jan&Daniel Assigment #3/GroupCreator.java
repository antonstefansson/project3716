//GroupCreator creates a final list of all groups. 

import java.io.*;
import java.util.ArrayList;

class GroupCreator
{
	public static ArrayList<ArrayList<Student>> groups = new ArrayList<ArrayList<Student>>(); //List of Groups
	public static ArrayList<Student> group = new ArrayList<Student>(); //A group list of size specified by the professor. 

	static void createGroup(int groupSize){
	
		ArrayList<Student> studentList = SystemWork.getStudentList(); 
		//studentList is provided by the system.
		
		int size = studentList.size() - 1;
		
		for(int i = 0; i<size; i+=groupSize)
		{
			for(int y=0; y<groupSize; y++)
			{
				group.add(studentList.get(y));
			}
		groups.add(group);
		}
}
}