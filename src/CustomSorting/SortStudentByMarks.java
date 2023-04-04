package CustomSorting;
import java.util.Comparator;
import sdbms.Student;

public class SortStudentByMarks implements Comparator<Student>
{
	@Override
	public int compare(Student s1, Student s2) 
	{
		Integer x=s1.getMarks();
		Integer y=s2.getMarks();
		return x.compareTo(y);
	}
}
