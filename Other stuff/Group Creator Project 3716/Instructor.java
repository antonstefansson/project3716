
public class Instructor {
	/*
	 * Class for changing criteria and editing groups
	 */
	Project proj = new Project();
	public Project createNewProject() {
		proj = new Project();
		return proj;
	}
	public void setGroupSize( int size ) {
		proj.setSize( size );
	}
}
