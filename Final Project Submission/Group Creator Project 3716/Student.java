
public class Student {
	/*
	 * Holds information for one student
	 */
	String StudentNo = "";
	String StudentName = "";
	String StudentEmail = "";
	double gpa = 0;
	int[] selfEvalValues = new int[10];
	double selfEvalScore = 0.0;
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
	public void setGPA( double newgpa ) {
		gpa = newgpa;
	}
	public double getStudentGPA() {
		return gpa;
	}
	public void setEmail( String newemail ) {
		StudentEmail = newemail;
	}
	public int[] getSelfEvalValues() {
		return selfEvalValues;
	}
	public void setSelfEvalValues( int[] newScores ) {
		selfEvalValues = newScores;
	}
	public double getSelfEvalScore() {
		return selfEvalScore;
	}
	public void setSelfEvalScore( double newScore ) {
		selfEvalScore = newScore;
	}
}
