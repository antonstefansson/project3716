//
// Jan Mertlik & Daniel Stratton
//
// Code Skeleton 
//	
// ProjectManager class is an abstract class that handles all input from users, as it is our UI
//

public abstract class ProjectManager
{

private User user;
private Project project; 

	public void logIn(){
	//Let's the user log into the system and identifies the user. 
	
	this.user = user;
	
	}
	
	// ===================== Professor's Most Important Methods =====================
	
	public void setGroupPreferences() {
		//Professor sets the preferences for the groups.
	}
	
	public void setUpProject() {
		//This method creates a new project
		
		 this.project = new Project(...) 
	}
	public void selfEvalInit() {
		//Creating a self evaluation 
		
		this.project = new SelfEvaluation(...) 
	}
	
	public Iterable<StudentGroup> getGroups() {
		//returns the student groups
		return project.getStudentGroups();
	}
	
	public void editGroups() {
		//Let's the professor edit the groups if he needs to make any changes. 
	}
	
	// ===================== Student's Most Important Methods =====================
	
	public void StudentSortOutSetup() {
		//Students input who they want to work with and fill their Self Evaluation
		
		this.project = new StudentPreference(...) 
	}
	
	public void privateSchedule() {
		//Students input their private activities
	}
}
	