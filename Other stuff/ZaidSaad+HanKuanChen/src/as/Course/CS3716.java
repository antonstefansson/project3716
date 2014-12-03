package as.Course;

import java.util.ArrayList;
import as.Assignment.Assignment;
import as.Group.Group;
import as.Grouping.Grouping;
import as.Instructor.Instructor;

public class CS3716 extends Course
{
	private ArrayList<Group> group=new ArrayList<Group>();
	public CS3716(Instructor instructor)
	{
		super(3716,instructor,"software methodology",100);
	}
	public void addGroup(Group group)
	{
		this.group.add(group);
	}
	public void addAssignment(Assignment assignment)
	{
		for(Group g:group)
			g.addAssignment(assignment);
	}
	public ArrayList<Group> getGroup()
	{
		return group;
	}
	public void grouping(Grouping grouping)
	{
		group=grouping.execute(student);
	}
}