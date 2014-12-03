package as.Course;

import java.util.ArrayList;
import as.Assignment.Assignment;
import as.Group.Group;
import as.Group.Student;
import as.Grouping.Grouping;
import as.Instructor.Instructor;
import as.Score.Score;

public abstract class Course
{
	private int num;
	private Instructor instructor;
	private String content;
	private Score score;
	protected ArrayList<Student> student=new ArrayList<Student>();
	public Course(final int num,Instructor instructor,String content,final int score)
	{
		this.num=num;
		this.instructor=instructor;
		instructor.setCourse(this);
		this.content=content;
		this.score=new Score(score);
	}
	public boolean equals(Course course)
	{
		if(course==null||getClass()!=course.getClass())
			return false;
		return num==course.num;
	}
	public Instructor getInstructor()
	{
		return instructor;
	}
	public Score getScore()
	{
		return score;
	}
	public void markScore(final int score)
	{
		this.score.setScore(score);;
	}
	public String getContent()
	{
		return content;
	}
	public void addStudent(Student stu)
	{
		this.student.add(stu);
	}
	public abstract void grouping(Grouping grouping);
	public abstract void addAssignment(Assignment assignment);
	public abstract ArrayList<Group> getGroup();
}