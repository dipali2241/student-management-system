package student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signup_controller
 */
@WebServlet("/signup_controller")
public class signup_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		
		 String name = request.getParameter("name");  
	        String email = request.getParameter("email");  
	        String phone = request.getParameter("phone");  
	        String password = request.getParameter("password");  

	        // Basic validation example (could be extended)  
	        if(name == null || email == null || phone == null || password == null ||  
	           name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {  
	            response.getWriter().write("Please fill in all fields.");  
	        	
	        	return ;  
	        }
	        else
	        {
	        	response.sendRedirect("login.html");  
	        }
	        
	        
	        // TODO: Save user info in DB here (using JDBC, JPA, etc.)  

	        // For demonstration: just send success response  
	        //response.setContentType("text/html");  
//	        response.getWriter().write("<h2>Signup successful</h2>");  
//	        response.getWriter().write("<p>Name: " + name + "</p>");  
//	        response.getWriter().write("<p>Email: " + email + "</p>");  
//	        response.getWriter().write("<p>Phone: " + phone + "</p>");  
	}

}
