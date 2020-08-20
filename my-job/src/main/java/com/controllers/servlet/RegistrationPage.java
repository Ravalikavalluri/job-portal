package com.controllers.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.util.UserDao;
import com.dao.util.UserDto;
import com.model.dao.LoginModel;

@WebServlet(name = "Register", urlPatterns = { "/Register" }) //set in web.xml
public class RegistrationPage extends HttpServlet{
	private static final long serialVersionUID = 1L;	
	private static String ADMINPG= "/admin.jsp";
	//private static String WELCMPG= "/welcome.jsp";	
	private UserDao dao;	

	public RegistrationPage() {
		super();
		dao = new UserDao(); //create new data object
		
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		UserDto user = new UserDto();	//create new user object
		PrintWriter pwOut= response.getWriter();
		
		//get input from jsp and store it in user object
		String fn=request.getParameter("fname");
		String ln=request.getParameter("lname");
		String phn=request.getParameter("phoneNo");
		String un=request.getParameter("usnm");
		String dob=request.getParameter("dob");
		String pw = request.getParameter("psword");
		String email=request.getParameter("eml");
		String userID = request.getParameter("userid");
		user.setFirstName(fn);
		user.setLastName(ln);
		user.setPhoneNo(phn);
		user.setUsername(un);
		user.setDob(dob);
		user.setPassword(pw);
		user.setEmailID(email);
		
		//if there is no ID field a new user is being created and added to database
		if(userID==null||userID.isEmpty())
		{
			dao.createUser(user);				
			pwOut.print("Registration Successful! Please Login.");
			response.setContentType("text/html");
			RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
			view.include(request, response); //index page is reloaded with text for new user to login
		}
		//if there is an ID field a user is being edited
		else
		{
			user.setUserID(Integer.parseInt(userID));			
			dao.editAccount(user);
			request.setAttribute("users",dao.listUsers());
			RequestDispatcher view = request.getRequestDispatcher(ADMINPG);		
			view.forward(request, response); //reload admin page with updated table
		}				
			
	}


}
