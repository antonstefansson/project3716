package as.Group;

import java.util.Iterator;
import as.Schedule.Schedule;

public class Student
{
	private int grade;
	private Schedule schedule;
	private String name;
	public Student(String name,int grade)
	{
		this.name=name;
		this.grade=grade;
	}
	public Iterator<Integer> getFreeTime()
	{
		return schedule.getSpaceTime();
	}
	public String getName()
	{
		return name;
	}
	public int getGrade()
	{
		return grade;
	}
}