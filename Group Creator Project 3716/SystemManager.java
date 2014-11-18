import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;

public class SystemManager {
	static ArrayList<Student> studentList = new ArrayList<Student>();

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader( new FileReader( "ClassList.txt" ) );
			String temp;
			while( ( temp = br.readLine() ) != null ) {
				studentList.add( new Student( temp, br.readLine(), br.readLine() ) );
				temp = br.readLine();
			}
		}
		catch( Exception e ) {
			System.out.println("Class List file \"ClassList.txt\" does not exist");
			
		}
		Project proj = new Project();
		Admin ad = new Admin( proj );
		GroupCreator gc = new GroupCreator();
		ArrayList<ArrayList<Student>> listofgroups = gc.createGroups( proj.getSize(), studentList);
		try {
			PrintWriter pw = new PrintWriter( new File( "CompletedGroups.txt" ) );
			for( ArrayList<Student> s : listofgroups ) {
				for( Student stu : s ) {
					pw.println( stu.getStudentNo() + "\t\t" + stu.getStudentName() );
				}
				pw.println(" ");
			}
			pw.close();
		}
		catch( Exception e ) {
			System.out.println( "Error creating group file" );
		}
		for( ArrayList<Student> s : listofgroups ) {
			for( Student stu : s ) {
				System.out.println( stu.getStudentNo() + "\t\t" + stu.getStudentName() );
			}
			System.out.println(" ");
		}

	}

}
