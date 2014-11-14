package as.Group;

import java.util.ArrayList;
import java.util.Iterator;
import as.Assignment.Assignment;
import as.Course.Course;

public class Group
{
	private ArrayList<Student> member=new ArrayList<Student>();
	private ArrayList<Assignment> assignment=new ArrayList<Assignment>();
	public void finishAssignment(){}
	public void haveMeeting() throws Exception
	{
		ArrayList<Integer> schedule=new ArrayList<Integer>();
		for(Iterator<Integer> iter=member.get(0).getFreeTime();iter.hasNext();)
			schedule.add(iter.next());
		for(int i=1;i!=member.size();++i)
		{
			ArrayList<Integer> temp=new ArrayList<Integer>();
			for(Iterator<Integer> iter=member.get(0).getFreeTime();iter.hasNext();)
				schedule.add(iter.next());
			for(int j=0;j!=schedule.size();++j)
			{
				boolean notExist=true;
				for(int k=0;k!=temp.size();++k)
					if(schedule.get(j).equals(temp.get(k)))
					{
						notExist=false;
						break;
					}
				if(notExist)
					schedule.remove(j);
			}
		}
		if(schedule.size()<1)
			throw new Exception("No time to meet.");
	}
	public void addAssignment(Assignment assignment)
	{
		this.assignment.add(assignment);
	}
	public void addMember(Student stu)
	{
		member.add(stu);
	}
	public Iterator<Student> getMember()
	{
		return member.iterator();
	}
	public void changeMember(Course course,Student our,Group their,Student theirStu) throws Exception
	{
		for(Student stu:member)
			if(stu.equals(our))
				if(course.getInstructor().permitChangeMember(this,our,their,theirStu))
				{
					Student temp=stu;
					member.remove(stu);
					member.add(theirStu);
					for(Student stu2:their.member)
						if(stu2.equals(theirStu))
						{
							their.member.remove(stu2);
							their.member.add(temp);
							return ;
						}
					throw new Exception("Student does not exist.");
				}
		throw new Exception("Student does not exist.");
	}
	public int memberCount()
	{
		return member.size();
	}
	public String toString()
	{
		String temp="Group members: "+member.get(0).getName();
		for(int i=1;i!=member.size();++i)
			temp+=", "+member.get(i).getName();
		return temp;
	}
}