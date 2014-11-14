package as.Course;

import java.util.ArrayList;
import as.Assignment.Assignment;
import as.Group.Group;
import as.Grouping.Grouping;
import as.Instructor.Instructor;

public class SeminarForCS3716 extends Course
{
	public SeminarForCS3716(int num,Instructor instructor,String content,int score)
	{
		super(num,instructor,content,score);
	}

	public void grouping(Grouping grouping){}
	public void addAssignment(Assignment assignment){}
	public ArrayList<Group> getGroup()
	{
		return null;
	}
}