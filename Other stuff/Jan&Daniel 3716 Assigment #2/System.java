//
// Jan Mertlik & Daniel Stratton
//
// Code Skeleton 
//	
// System class accesses data from the school databases and also sets private schedules for the students
//

public class System extends ProjectManager
{

	public Iterable<Student> getListOfStudents(String courseNumber){
	//Access school system and gets the list of students.
	
	return studentList; 
	}
	
	public Iterable<Schedule> getClassSchedule(Student student){
	//Access school system and gets student's class schedule
	
	return student.schedule;
	}
	
	public Iterable<Schedule> getPrivatechedule(Student student){
	//Helps the student get create the private schedule
	
	return student.schedule;
	}
	
}
	
	