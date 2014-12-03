import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StorageImplementation implements Storage {
	/*
	 * Implementation of Storage interface. 
	 *   Reads class list from a predetermined text file
	 *   Stores completed groups in a predetermined text file
	 */
	public ArrayList<Student> getClassList( String CourseNo ) {
		ArrayList<Student> studentList = new ArrayList<Student>();
		try {
			BufferedReader br = new BufferedReader( new FileReader( "ClassList" + CourseNo +".txt" ) );
			String temp;
			while( ( temp = br.readLine() ) != null ) {
				studentList.add( new Student( temp, br.readLine(), br.readLine() ) );
				temp = br.readLine();
			}
			br.close();
		}
		catch( Exception e ) {
			return new ArrayList<Student>();
		}
		return studentList;
	}
	
	public void storeGroups( ArrayList<ArrayList<Student>> listofgroups, String CourseNo ) {
		try {
			PrintWriter pw = new PrintWriter( new File( "CompletedGroups" + CourseNo + ".txt" ) );
			pw.println( "Finalized Groups for " + CourseNo + "\n\n" );
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
	}
	
	public void getGPAs( ArrayList<Student> studentList ) {
		try {
			BufferedReader br = new BufferedReader( new FileReader( "StudentGPAs.txt" ) );
			String temp;
			while( ( temp = br.readLine() ) != null ) {
				for( Student s : studentList ) {
					if( s.getStudentNo().equals( temp ) ) {
						s.setGPA( Double.parseDouble( br.readLine() ) );
					}
				}
				temp = br.readLine();
			}
			br.close();
		}
		catch( Exception e ) {
			return;
		}
	}
}
