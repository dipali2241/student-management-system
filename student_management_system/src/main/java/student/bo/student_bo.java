package student.bo;

public class student_bo 
{
	private int id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() 
	{
		return "student_bo [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password="
				+ password + "]";
	}
	
	
	
}
