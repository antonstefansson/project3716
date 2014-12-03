import java.util.ArrayList;

public class SystemManager {
	/**
	 * Delegates tasks to other classes in the system
	 */
	ArrayList<Student> studentList;
	ArrayList<ArrayList<Student>> listofgroups;
	GroupCreator gc;
	Storage st;
	Instructor inst;
	Project proj;

	public SystemManager() {
		studentList = new ArrayList<Student>();
		listofgroups = new ArrayList<ArrayList<Student>>();
		gc = new GroupCreator();
		st = new StorageImplementation();
	}
	
	public void readClassList( String CourseNo ) {
		studentList = st.getClassList( CourseNo );
	}
	
	public int getNumStudents() {
		return studentList.size();
	}
	
	public void createProject() {
		Instructor inst = new Instructor();
		proj = inst.createNewProject();
	}
	
	public void createGroups( int size ) {
		proj.setSize( size );
		listofgroups = gc.createGroups( proj.getSize(), studentList);
	}
	
	public ArrayList<ArrayList<Student>> getGroups() {
		return listofgroups;
	}
	
	public void storeGroups() {
		st.storeGroups( listofgroups );
	}

}
