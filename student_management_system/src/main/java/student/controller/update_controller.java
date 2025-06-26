package student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import student.bo.addstudent_bo;
import student.dao.Student_dao;

/**
 * Servlet implementation class update_controller
 */
@WebServlet("/update_controller")
public class update_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html") ;
        PrintWriter pw=response.getWriter();
        
        int id= Integer.parseInt(request.getParameter("id"));
        
        String name= request.getParameter("name");
        String surname= request.getParameter("surname");
        String age= request.getParameter("age");
        String std= request.getParameter("std");
        String address= request.getParameter("address");
       
        
        //pw.write(name+"\t"+email+"\t"+phone+"\t"+pass);
        
        addstudent_bo eb=new addstudent_bo();
        
        eb.setId(id);
        eb.setName(name);
        eb.setSurname(surname);
        eb.setAge(age);
        eb.setStd(std);
        eb.setAddress(address);
        
        
      int status=Student_dao.update(eb);
      
      if(status>0)
      {
    	  response.sendRedirect("getstud_controller");
      }
      else
      {
      	pw.write("something went wrong");
      	RequestDispatcher re=request.getRequestDispatcher("home.html");
      	re.include(request,response);
      }
      
    }
	

}
