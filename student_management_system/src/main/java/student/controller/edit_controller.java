package student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import student.bo.addstudent_bo;
import student.dao.Student_dao;

/**
 * Servlet implementation class edit_controller
 */
@WebServlet("/edit_controller")
public class edit_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html") ;
        PrintWriter pw=response.getWriter();
        
        String id= request.getParameter("id");
        int eid= Integer.parseInt(id);
        
       addstudent_bo eb= Student_dao.getstudbyid(eid);
        
       pw.print("<form action='update_controller' method='post'>");
       pw.print("<table>");
       pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+eb.getId()+"'/></td></tr>");
       pw.print("<tr><td>Name</td><td><input type='text' name='name' value='"+eb.getName()+"'/></td></tr>");
       pw.print("<tr><td>Surname</td><td><input type='text' name='surname' value='"+eb.getSurname()+"'/></td></tr>");
       pw.print("<tr><td>Age</td><td><input type='text' name='age' value='"+eb.getAge()+"'/></td></tr>");
       pw.print("<tr><td>Std</td><td><input type='text' name='std' value='"+eb.getStd()+"'/></td></tr>");
       pw.print("<tr><td>Address</td><td><input type='text' name='address' value='"+eb.getAddress()+"'/></td></tr>");
       
       
       pw.print("<tr><td><input type='submit' value='Update'/></td></tr>");
       pw.print("</table>");
       pw.print("</form>");
	}

}
