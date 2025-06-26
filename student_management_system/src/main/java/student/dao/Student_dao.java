package student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import student.bo.*;

public class Student_dao 
{
	public static Connection getConnection()
	  {
		  Connection con=null;
		  
		  try 
		  {
			  String url="jdbc:mysql://localhost:3306/student?useSSL=false&allowPublicKeyRetrieval=true";
		      String username="root";
		      String password="12345";
		      Class.forName("com.mysql.cj.jdbc.Driver");
		       con=DriverManager.getConnection(url,username,password);
		  } 
		  catch (Exception e) 
		  {
			System.out.println(e);
		  }
		  
		  return con;
		  
	  }
		 

	public static int signup(student_bo em)
	  {
		  int status =0;
		  
		  try
		  {
		   Connection con= Student_dao.getConnection();
		   String sql="insert into add_stud(name,email,phone,password) values (?,?,?,?)";
	       PreparedStatement ps=con.prepareStatement(sql);
	       ps.setString(1, em.getName());
	       ps.setString(2, em.getEmail());
	       ps.setString(3, em.getPhone());
	       ps.setString(4, em.getPassword());
	       
	      status= ps.executeUpdate();
		  }
		  catch(Exception e)
		  {
			  System.out.println(e);
		  }
		  
		  return status;
	 }
	
	public static boolean userlogin(String email, String pass)
	  {
		  
		  boolean status= false;
		  try 
		  {
			Connection con= Student_dao.getConnection();
			String sql="select * from add_stud where email=? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1, email);
		     ps.setString(2, pass);
		     
		    ResultSet rs= ps.executeQuery();
		    status= rs.next();
		  } 
		  catch (Exception e) 
		  {
			System.out.println(e);
		  }
		  
		  return status;
		  
		 }
	
	 public static int addstudent(addstudent_bo eb)
	  {
		  int status=0;
		  try
		  {
		   Connection con= Student_dao.getConnection();
		   String sql="insert into stud_msys(name,surname,age,std,address) values(?,?,?,?,?)";
	       PreparedStatement ps=con.prepareStatement(sql);
	       ps.setString(1, eb.getName());
	       ps.setString(2, eb.getSurname());
	       ps.setString(3,eb.getAge());
	       ps.setString(4,eb.getStd());
	       ps.setString(5, eb.getAddress());
	      
	       
	      status= ps.executeUpdate();
		  }
		  catch(Exception e)
		  {
			  System.out.println(e);
		  }
		  
		  return status;
		  
		}
	 
	 public static List getliststud()
	  {
		  List<addstudent_bo> list =new ArrayList<addstudent_bo>();
		  try
		  {
		  Connection con= Student_dao.getConnection();
		  String sql="select * from stud_msys";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				addstudent_bo  eb=new addstudent_bo ();
				eb.setId(rs.getInt(1));
				eb.setName(rs.getString(2));
				eb.setSurname(rs.getString(3));
				eb.setAge(rs.getString(4));
				eb.setStd(rs.getString(5));
				eb.setAddress(rs.getString(6));
				
				list.add(eb);
			}
		  }
		  catch(Exception e)
		  {
			  System.out.println(e);
		  }
		  return list;
	  }
	 
	 public static addstudent_bo getstudbyid(int id)
	  {
		 addstudent_bo eb=new addstudent_bo();
		  try 
		  {
			  Connection con= Student_dao.getConnection();
			  String sql="select * from stud_msys where id=?";
			  PreparedStatement ps=con.prepareStatement(sql);
			  ps.setInt(1, id);
			  
			  ResultSet rs=ps.executeQuery();
			  
			  if(rs.next())
			  {
				  eb.setId(rs.getInt(1));
				  eb.setName(rs.getString(2));
				  eb.setSurname(rs.getString(3));
				  eb.setAge(rs.getString(4));
				  eb.setStd(rs.getString(5));
				  eb.setAddress(rs.getString(6));
				  
				  
				  
			  }
		  } 
		  catch (Exception e)
		  {
			System.out.println(e);
		}
		 
		  return eb;
		  
	  }
	 
	 public static int update(addstudent_bo eb)
	  {
		  int status=0;
		  try
		  {
		   Connection con= Student_dao.getConnection();
		   String sql="update stud_msys set name=?,surname=?,age=?,std=?,address=? where id=?";
	       PreparedStatement ps=con.prepareStatement(sql);
	       
	      
	       ps.setString(1, eb.getName());
	       ps.setString(2, eb.getSurname());
	       ps.setString(3, eb.getAge());
	       ps.setString(4,eb.getStd());
	       ps.setString(5, eb.getAddress());
	       ps.setInt(6, eb.getId());
	       
	      
	       
	      status= ps.executeUpdate();
		  }
		  catch(Exception e)
		  {
			  System.out.println(e);
		  }
		  
		  
		  	return status;
	  }
	 
	 public static int delete(int id)
	  {
		  int status=0;
		  try 
		  {
		  Connection con= Student_dao.getConnection();
		  String sql="delete from stud_msys where id=?";
		  PreparedStatement ps=con.prepareStatement(sql);
		  ps.setInt(1, id);
		  
		  status=ps.executeUpdate();
		  }
		  catch(Exception e)
		  {
			  System.out.println(e);
		  }
		  
		  return status;
	  }
}
