package student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import student.dao.*;

/**
 * Servlet implementation class login_controller
 */
@WebServlet("/login_controller")
public class login_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html") ;
        PrintWriter pw=response.getWriter();
        
       String email= request.getParameter("email");
       String password= request.getParameter("password");
       
       if(Student_dao.userlogin(email, password))
       {
       	
       	pw.write("username or password is wrong");
       	RequestDispatcher re=request.getRequestDispatcher("login.html");
       	re.include(request,response);
       }
       else
       {
    	   RequestDispatcher re=request.getRequestDispatcher("home.html");
          	re.include(request,response); 
       	
       }

	}

}
