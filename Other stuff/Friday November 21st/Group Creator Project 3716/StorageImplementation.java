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
			BufferedReader br = new BufferedReader( new FileReader( "ClassList.txt" ) );
			String temp;
			while( ( temp = br.readLine() ) != null ) {
				studentList.add( new Student( temp, br.readLine(), br.readLine() ) );
				temp = br.readLine();
			}
		}
		catch( Exception e ) {
			return new ArrayList<Student>();
		}
		return studentList;
	}
	
	public void storeGroups( ArrayList<ArrayList<Student>> listofgroups ) {
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
	}
}
