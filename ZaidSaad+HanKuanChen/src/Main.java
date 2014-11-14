import java.util.ArrayList;
import as.Course.CS3716;
import as.Group.Group;
import as.Group.Student;
import as.Instructor.Instructor;

public class Main
{
	public static void main(String[] args)
	{
		Instructor instr=new Instructor();
		CS3716 cs3716=new CS3716(instr);
		ArrayList<Student> stu=new ArrayList<Student>();
		stu.add(new Student("A",1));
		stu.add(new Student("B",2));
		stu.add(new Student("C",3));
		stu.add(new Student("D",4));
		for(int i=0;i!=stu.size();++i)
			cs3716.addStudent(stu.get(i));
		instr.grouping(2,false);
		ArrayList<Group> group=cs3716.getGroup();
		for(int i=0;i!=group.size();++i)
			System.out.println(group.get(i));
	}
}