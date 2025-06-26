package student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import student.bo.student_bo;
import student.dao.Student_dao;

/**
 * Servlet implementation class student_controller
 */
@WebServlet("/student_controller")
public class student_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public student_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html") ;
        PrintWriter pw=response.getWriter();
        
       String name= request.getParameter("name");
       String email= request.getParameter("email");
       String phone= request.getParameter("phone");
       String pass= request.getParameter("password");
       
      // pw.write(name+"\t"+email+"\t"+phone+"\t"+pass);
       
       student_bo em=new student_bo();
       em.setName(name);
       em.setEmail(email);
       em.setPhone(phone);
       em.setPassword(pass);
       
     int status= Student_dao.signup(em);
     
     if (status>0)
     {
    	 RequestDispatcher re=request.getRequestDispatcher("login.html");
        	re.include(request,response);
     }
     else
     {
    	 pw.write("username or password is wrong");
    	 RequestDispatcher re=request.getRequestDispatcher("signup.html");
     	re.include(request,response);
     }
     
	}

}
