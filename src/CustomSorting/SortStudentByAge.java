package CustomSorting;
import java.util.Comparator;
import sdbms.Student;

public class SortStudentByAge implements Comparator<Student>
{
	@Override
	public int compare(Student s1, Student s2) 
	{
		Integer x=s1.getAge();
		Integer y=s2.getAge();
		return x.compareTo(y);
	}

}
