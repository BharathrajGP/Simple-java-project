package sdbms;

public class Student
{
	private String id;
	private String name;
	private int age;
	private int marks;
	static int count=001;
	public Student(String name,int age,int marks)
	{
		this.name=name;
		this.age=age;
		this.marks=marks;
		id="01JST17CV"+count;
		count++;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public int getAge() 
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getMarks()
	{
		return marks;
	}
	public void setMarks(int marks) 
	{
		this.marks = marks;
	}
	public String getId()
	{
		return id;
	}
	@Override
	public String toString()
	{
		return "Id:"+id+" Age:"+age+" Name:"+name+" Marks:"+marks;
	}
}
