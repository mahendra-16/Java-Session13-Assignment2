package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;



public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("username");
		String pass = request.getParameter("password");
		
		if(Validate.checkUser(email, pass)){
			RequestDispatcher rd = request.getRequestDispatcher("Welcome");
			rd.forward(request, response);
		}else{
			
			out.println("Username or password incorrect...");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}


	}

}
