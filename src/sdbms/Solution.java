package sdbms;

import java.util.*;
import coustomisedException.*;

public class Solution 
{
	static 
	{
		System.out.println("Welcome to Student database management System");
	}
	public static void main(String[] args) 
	{
		Scanner ip=new Scanner(System.in);
		StudentManagementSystem s=new StudentManagementSystem_Impl();
		while(true)
		{
			System.out.println("Select Options");
			System.out.println("1.Add Student\n2.Display Student\n3.Display All Students\n4.Remove Student\n5.Remove All Student\n6.Update Student\n7.Count the No. of Student\n8.Sort The Student\n9.Student With Highest Marks\n10.Student With LowestMarks\n11.Exit");
			int choice=ip.nextInt();
			switch(choice)
			{
			case 1:s.addStudent();
			break;
			case 2:s.displayStudent();
			break;
			case 3:s.displayAllStudents();
			break;
			case 4:s.removeStudent();
			break;
			case 5:s.removeAllStudents();
			break;
			case 6:s.updateStudent();
			break;
			case 7:s.countStudents();
			break;
			case 8:s.sortStudent();
			break;
			case 9:s.getStudentWithHighestMarks();
			break;
			case 10:s.getStudentWithLowestMarks();
			break;
			case 11:System.out.println("Thank You Visit Again!!!");
			System.exit(0);
			default:
				try
				{
					throw new InvalidChoiceException("------Invalid Choice------\n-----Enter Valid Choice-----");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
			System.out.println("---------------------------------------------------------------------");
		}
	}

}
