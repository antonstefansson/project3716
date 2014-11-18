import java.util.ArrayList;

public class GroupCreator {
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
}
