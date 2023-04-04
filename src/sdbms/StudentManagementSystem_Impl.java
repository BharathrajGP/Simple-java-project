package sdbms;
import java.util.*;

import CustomSorting.*;
import coustomisedException.*;

public class StudentManagementSystem_Impl implements StudentManagementSystem
{
	Scanner ip=new Scanner(System.in);
	Map<String,Student> db=new LinkedHashMap<String,Student>();
	@Override
	public void addStudent()
	{
		System.out.println("Enter Age");
		int age=ip.nextInt();
		String n1=ip.nextLine();
		System.out.println("Enter name");
		String name=ip.nextLine();
		System.out.println("Enter Marks");
		int marks=ip.nextInt();
		Student s1=new Student(name,age,marks);
		db.put(s1.getId(), s1);
		System.out.println("Student record successfully inserted");
		System.out.println("Student id is:"+s1.getId());
	}
	@Override
	public void displayStudent()
	{
		System.out.println("Enter Student ID");
		String new_id=ip.nextLine().toUpperCase();
		if(db.containsKey(new_id))
		{
			System.out.println(db.get(new_id));					
		}
		else
		{
			try
			{
				throw new StudentNotFoundException("Student With the id "+new_id+" Not found");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void displayAllStudents()
	{
		if(db.size()!=0)
		{
			System.out.println("Student details are as follows");
			Set<String> s=db.keySet();
			s.forEach(o -> System.out.println(db.get(o)));
		}
		else
		{
			try
			{
				throw new StudentNotFoundException("Student Data Base is empty Nothing there to display");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeStudent()
	{
		System.out.println("Enter Student Id");
		String id=ip.nextLine().toUpperCase();
		if(db.containsKey(id))
		{
			System.out.println("Student Record Found");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Student Record Deleted Successfully");
		}
		else
		{
			try
			{
				throw new StudentNotFoundException("Student With Id "+id+" is not found");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeAllStudents() 
	{
		if(db.size()!=0)
		{
			System.out.println("Students Record Available :"+db.size());
			db.clear();
			System.out.println("All Students Data Deleted Successfully");
			System.out.println("Students Record Available :"+db.size());
		}
		else
		{
			try
			{
				throw new StudentNotFoundException("Student Data Base is empty Nothing there to delete");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void updateStudent() 
	{
		System.out.println("Enter Student Id");
		String id=ip.nextLine().toUpperCase();
		if(db.containsKey(id))
		{
			Student std=db.get(id);
			System.out.println("Enter Choice");
			System.out.println("1.Update Age\n2.Update Name\n3.Update Marks");
			int choice=ip.nextInt();
			switch(choice)
			{
			case 1:System.out.println("Enter Age");
			int age=ip.nextInt();
			std.setAge(age);
			System.out.println("Age is Updated");
			break;
			case 2:System.out.println("Enter Name");
			String Name=ip.nextLine();
			std.setName(ip.nextLine());
			System.out.println("Name is Updated");
			break;
			case 3:System.out.println("Enter Marks");
			int marks=ip.nextInt();
			std.setMarks(marks);
			System.out.println("Marks is Updated");
			break;
			default:
				try
				{
					throw new InvalidChoiceException("Invalid Choice Kindly Enter Valid Choice");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
		else
		{
			try
			{
				throw new StudentNotFoundException("Student Database is Empty Nothing there to delete");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void countStudents() 
	{
		System.out.println("No Of Student Records: "+db.size());
	}
	@Override
	public void sortStudent() 
	{
		Set<String> keys=db.keySet();
		List<Student> list=new ArrayList<Student>();
		for(String key : keys)
		{
			list.add(db.get(key));
		}
		System.out.println("Enter Choice");
		System.out.println("1.Sort by Id\n2.Sort by Age\n3.Sort by Name\n4.Sort by Marks");
		int choice=ip.nextInt();
		switch(choice)
		{
		case 1:Collections.sort(list,new SortStudentById());
		display(list);
		break;
		case 2:Collections.sort(list,new SortStudentByAge());
		display(list);
		break;
		case 3:Collections.sort(list,new SortStudentByName());
		display(list);
		break;
		case 4:Collections.sort(list,new SortStudentByMarks());
		display(list);
		break;
		default:
			try
			{
				throw new InvalidChoiceException("Invalid Choice Kindly Enter Valid Choice");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	private static void display(List<Student> l)
	{
		for(Student s:l)
		{
			System.out.println(s);
		}
	}
	@Override
	public void getStudentWithHighestMarks() 
	{
		if(db.size()>=2)
		{
			Set<String> keys= db.keySet();
			List<Student> list=new ArrayList<Student>();
			for(String key : keys)
			{
				list.add(db.get(key));
			}
			Collections.sort(list,new SortStudentByMarks());
			System.out.println(list.get(list.size()-1));
		}
		else
		{
			
		}
	}
	@Override
	public void getStudentWithLowestMarks() 
	{
		Set<String> keys= db.keySet();
		List<Student> list=new ArrayList<Student>();
		for(String key : keys)
		{
			list.add(db.get(key));
		}		
		Collections.sort(list,new SortStudentByMarks());
		System.out.println(list.get(0));
	}
	
}
