
public class Student {
	/*
	 * Holds information for one student
	 */
	String StudentNo = "";
	String StudentName = "";
	String StudentEmail = "";
	public Student( String SNo, String SName, String SEmail ) {
		StudentNo = SNo;
		StudentName = SName;
		StudentEmail = SEmail;
	}
	public String getStudentNo() {
		return StudentNo;
	}
	public String getStudentName() {
		return StudentName;
	}
	public String getStudentEmail() {
		return StudentEmail;
	}
}
