import java.util.ArrayList;

public interface Storage {
	/*
	 * Interface for external data. Enables retrieval 
	 *   of class list and storage of created groups
	 */
	
	ArrayList<Student> getClassList( String CourseNo );
	
	void storeGroups( ArrayList<ArrayList<Student>> listofgroups, String CourseNo );
	
	void getGPAs( ArrayList<Student> studentList );
}
