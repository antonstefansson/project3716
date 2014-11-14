package as.Grouping;

import java.util.ArrayList;
import java.util.Comparator;
import as.Group.Group;
import as.Group.Student;


public class GroupingWithCriteria implements Grouping
{
	private int memberCount;
	public GroupingWithCriteria(final int memberCount)
	{
		this.memberCount=memberCount;
	}
	public ArrayList<Group> execute(ArrayList<Student> stu)
	{
		ArrayList<Student> temp=new ArrayList<Student>(stu);
		temp.sort(new Comparator<Group>());
		return t;
	}
}