package as.Instructor;

import as.Assignment.Assignment;
import as.Course.Course;
import as.Group.Group;
import as.Group.Student;
import as.Grouping.GroupingWithCriteria;
import as.Grouping.GroupingWithoutCriteria;

public class Instructor
{
	private Course course;
	public void giveAssignment()
	{
		course.addAssignment(new Assignment("Only 1 assignment.",100));
	}
	public void grouping(final int memberCount,final boolean criteria)
	{
		if(criteria)
			course.grouping(new GroupingWithCriteria(memberCount));
		else
			course.grouping(new GroupingWithoutCriteria(memberCount));
	}
	public void setCourse(Course course)
	{
		this.course=course;
	}
	public boolean permitChangeMember(Group lhs,Student lhsStu,Group rhs,Student rhsStu)
	{
		return true;
	}
}