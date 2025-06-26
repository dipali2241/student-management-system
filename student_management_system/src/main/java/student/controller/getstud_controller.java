package student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.bo.addstudent_bo;
import student.dao.Student_dao;

/**
 * Servlet implementation class getstud_controller
 */
@WebServlet("/getstud_controller")
public class getstud_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getstud_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html") ;
		  
		 PrintWriter pw=response.getWriter();
       

        pw.print("<table border='1px' width=100%>");
        pw.print("<tr><th>ID</th><th>NAME</th><th>SURNAME</th>"
        		+ "<th>AGE</th>"
        		+ "<th>STD</th><th>ADDRSS</th><th>EDIT</th><th>DELETE</th></tr>");
        
        List<addstudent_bo > list= Student_dao.getliststud();
        
        for(addstudent_bo eb:list)
        {
       	 pw.print("<tr><td>"+eb.getId()+"</td><td>"+eb.getName()+"</td><td>"+eb.getSurname()+"</td><td>"+eb.getAge()+"</td><td>"+eb.getStd()+"</td><td>"+eb.getAddress()+"</td><td>"+"<a href='edit_controller?id="+eb.getId()+"'>edit</a></td><td>"+"<a href='delete_controller?id="+eb.getId()+"'>delete</a></td></tr>");
       	
             
        }
        pw.print("</table>");
        
        pw.print("<a href='home.html'>Back</a>");

	
	
	
	}

}
