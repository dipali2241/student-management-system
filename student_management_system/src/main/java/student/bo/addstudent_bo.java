package student.bo;

public class addstudent_bo 
{
	private int id;
	private String name;
	private String surname;
	private String age;
	private String std;
	private String address;
	
	
	public addstudent_bo( String name, String surname, String age, String std, String address) {
		super();
		
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.std = std;
		this.address = address;
	}
	
	public addstudent_bo()
	{
		super();
	}

	public int getId()
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getSurname() 
	{
		return surname;
	}
	public void setSurname(String surname) 
	{
		this.surname = surname;
	}
	public String getAge()
	{
		return age;
	}
	public void setAge(String age)
	{
		this.age = age;
	}
	public String getStd() 
	{
		return std;
	}
	public void setStd(String std)
	{
		this.std = std;
	}
	public String getAddress() 
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	@Override
	public String toString() {
		return "id" + id + " name :" + name + " surname :" + surname + " age :" + age + " std :" + std
				+ " address :" + address;
	}
	
	
	
}
