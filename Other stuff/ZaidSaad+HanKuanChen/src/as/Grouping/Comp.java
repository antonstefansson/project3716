package as.Grouping;

public Comp implements Comparator<Student>
{
	public int compare(Group lhs,Group rhs)
	{
		if(lhs.getGrade()<rhs.getGrade())
			return -1;
		if(rhs.getGrade()<lhs.getGrade())
			return 1;
		return 0;
	}
}