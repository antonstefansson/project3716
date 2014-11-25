import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GroupCreator {
	/*
	 * Creates groups based on given criteria
	 */
	public ArrayList<ArrayList<Student>> createGroups( int size, ArrayList<Student> studentList ) {
		ArrayList<ArrayList<Student>> listofgroups = new ArrayList<ArrayList<Student>>();
		int numGroups = studentList.size()/size;
		for( int i = 0; i < numGroups; i ++ ) {
			listofgroups.add( new ArrayList<Student>() );
		}
		int i = 0;
		int group = 0;
		while( i < studentList.size() ) {
			if( studentList.size()-i < size ) {
				group = listofgroups.size() - 1;
				while( i < studentList.size() ) {
					listofgroups.get(group).add(studentList.get(i));
					i ++;
					group --;
					if( group == -1 ) {
						group = listofgroups.size() - 1;
					}
				}
				break;
			}
			int j = 1;
			while( j <= size ) {
				listofgroups.get(group).add(studentList.get(i));
				i ++;
				j ++;
			}
			group ++;
		}
		return listofgroups;
	}
	
	public ArrayList<ArrayList<Student>> createGroupsGPA( int size, ArrayList<Student> studentList ) {
		ArrayList<Student> tempStudentList = new ArrayList<Student>( studentList );
		ArrayList<Student> sortStudentList = new ArrayList<Student>();
		Collections.sort( tempStudentList, new Comparator<Student>() {
			@Override public int compare( Student s1, Student s2 ) {
				return (int) (s1.getStudentGPA()*10.0 ) - (int) ( s2.getStudentGPA()*10.0 );
			}
		} );
		boolean start = true;
		while( tempStudentList.size() != 0 ) {
			if( start ) {
				sortStudentList.add( tempStudentList.remove( 0 ) );
				start = false;
			}
			else {
				sortStudentList.add( tempStudentList.remove( tempStudentList.size() - 1 ) );
				start = true;
			}
		}
		return createGroups( size, sortStudentList );
	}
}
