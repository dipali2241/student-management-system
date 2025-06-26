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
 * Servlet implementation class addstud_controller
 */
@WebServlet("/addstud_controller")
public class addstud_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addstud_controller() {
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
       String surname=request.getParameter("surname");
       String age=request.getParameter("age");
       String std=request.getParameter("std");
       String address=request.getParameter("address");
       
       addstudent_bo eb=new addstudent_bo (name,surname,age,std,address);
       
     int status=  Student_dao.addstudent(eb);
     

     if (status>0)
     {
     	pw.write("data inserted");
     	RequestDispatcher re=request.getRequestDispatcher("addstud.html");
     	re.include(request,response);
     }
     else
     {
     	pw.write("something went wrong");
     	RequestDispatcher re=request.getRequestDispatcher("home.html");
     	re.include(request,response);
     }
     pw.print("<a href='home.html'>Back</a>");

	}

       
       
	

}
