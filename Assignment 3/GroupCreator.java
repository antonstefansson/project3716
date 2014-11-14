import java.util.ArrayList;
import java.util.Date;

/**
 *
 * Executable Architecture for Creating Groups for Projects
 *
 * Niall Delaney       Anton Stefansson
 *   201131133             201452901
 *
 */

/*
 * Fetches class list from university systems. Creates project
 * with list of students based on class list from university.
 */
public class GroupCreator {
    Project[] projects;
    public void createProject(int courseNo) {

    }
}

/*
 * Holds criteria provided by the instructor. Also holds a 
 * template of the Self-Evaluation, it has the questions but no
 * answers. Also creates the list of StudentInfos and the 
 * object for each student when the project is created.
 */
class Project {
    Date deadline;
    int groupSize;
    int preferenceListSize;
    boolean useSelfEval;
    boolean useGrades;
    int[] classList;
    ListOfGroups finishedGroups;
    MustWorkTogether forcedGroups;
    MustNotWorkTogether disallowedGroups;
    SelfEval selfEvalTemplate;
    StudentInfo[] infoList;
    public Project( int[] studentNos ) {
        classList = studentNos;
        infoList = new StudentInfo[classList.length];
        for( int i = 0; i < classList.length; i++ ) {
            infoList[i] = new StudentInfo(classList[i]);
        }
    }
    public void setDeadline( Date date ) {
        deadline = date;
    }
    public void setGroupSize( int size ) {
        groupSize = size;
    }
    public void setPreferenceSize( int size ) {
        preferenceListSize = size;
    }
    public void setUseGrades( boolean grades ) {
        useGrades = grades;
    }
    public void setUseSelfEval( boolean selfEval ) {
        useSelfEval = selfEval;
    }
    public void setupSelfEval() {
        
    }
    public void setupForcedGroups() {

    }
    public void setupDisallowedGroups() {

    }
    public boolean deadlinePassed() {
        return false;
    }
    public SelfEval getSelfEval() {
        return selfEvalTemplate;
    }
    public int[] getClassList() {
        return classList;
    }
    public void makeGroups() {

    }
    public void editGroups() {

    }
    public ArrayList<Object> viewStudentLists( int StudentNo ) {
        StudentInfo temp = null;
        for( StudentInfo s : infoList ) {
            if( StudentNo == s.getStudentNo() ) {
                temp = s;
            }
        }
        ArrayList<Object> lists = new ArrayList<Object>();
        lists.add(temp.getPositiveList());
        lists.add(temp.getNegativeList());
        return lists;
    }
    public void publishGroups() {

    }
}


class ListOfGroups {
    public void addGroup( int[] group ) {

    }
    public void delGroup( int[] group ) {

    }
}

class MustWorkTogether {
    public void addGroup( int[] group ) {

    }
    public void delGroup( int[] group ) {

    }
}

class MustNotWorkTogether {
    public void addGroup( int[] group ) {

    }
    public void delGroup( int[] group ) {

    }
}


class SelfEval {
    String[] selfEvalQuestions;
    int[] selfEvalAnswers;
    public SelfEval() {

    }
    public void addQuestion( String question ) {

    }
    public int[] getAnswers() {
        return selfEvalAnswers;
    }
}

/*
 * Holds information on individual student, and holds 
 * references to lists and Self-Evaluation for that
 * student.
 */
class StudentInfo {
    int studentNo;
    SelfEval selfEval;
    PrivateSchedule privateSchedule;
    PositiveList positiveList;
    NegativeList negativeList;
    public StudentInfo( int StudentNo ) {
        studentNo = StudentNo;
        privateSchedule = new PrivateSchedule();
        positiveList = new PositiveList();
        negativeList = new NegativeList();
    }
    public int getStudentNo() {
        return studentNo;
    }
    public PrivateSchedule getPrivSchedule() {
        return privateSchedule;
    }
    public void editPrivSchedule() {

    }
    public void doSelfEval() {

    }
    public SelfEval getSelfEval() {
        return selfEval;
    }
    public void editPositiveList() {

    }
    public PositiveList getPositiveList() {
        return positiveList;
    }
    public void editNegativeList() {

    }
    public NegativeList getNegativeList() {
        return negativeList;
    }
}


class PrivateSchedule {
    public PrivateSchedule() {

    }
}

class PositiveList {
    public PositiveList() {

    }
    public void addStudent( int StudentNo ) {

    }
    public void delStudent( int StudentNo ) {

    }
}

class NegativeList {
    public NegativeList() {

    }
    public void addStudent( int StudentNo ) {

    }
    public void delStudent( int StudentNo ) {

    }
}