package as.Grouping;

import java.util.ArrayList;
import as.Group.Group;
import as.Group.Student;

public class GroupingWithoutCriteria implements Grouping
{
	private final int memberCount;
	public GroupingWithoutCriteria(final int memberCount)
	{
		this.memberCount=memberCount;
	}
	public ArrayList<Group> execute(ArrayList<Student> stu)
	{
		ArrayList<Group> temp=new ArrayList<Group>();
		for(int i=0,j=0;i!=stu.size();++i,++j)
		{
			if(j%memberCount==0)
				temp.add(new Group());
			temp.get(temp.size()-1).addMember(stu.get(i));
		}
		return temp;
	}
}