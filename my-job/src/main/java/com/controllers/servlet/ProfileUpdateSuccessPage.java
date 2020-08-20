package com.controllers.servlet;

import com.dao.util.UserDao;
import com.dao.util.UserDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProfileUpdatePage", urlPatterns = { "/ProfileUpdatePage" }) //set in web.xml
public class ProfileUpdateSuccessPage extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String PROFILE_UPDATE= "/profileupdated.jsp";
    private UserDao dao;

    public ProfileUpdateSuccessPage() {
        super();
        dao = new UserDao(); //create new data object

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserDto user = new UserDto();	//create new user object
        PrintWriter pwOut= response.getWriter();

        //get input from jsp and store it in user object

        String email=request.getParameter("email");
        String firstName =request.getParameter("firstName");
        String lastName =request.getParameter("lastName");
        String password =request.getParameter("password");
        String phoneNo =request.getParameter("phoneNo");
        String dob =request.getParameter("dob");
        Float cgpa = Float.valueOf(request.getParameter("cgpa"));
        String bio =request.getParameter("bio");
        int exp = Integer.parseInt(request.getParameter("exp"));


        user.setEmailID(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setPhoneNo(phoneNo);
        user.setDob(dob);
        user.setCgpa(cgpa);
        user.setBio(bio);
        user.setExp(exp);







        dao.updateUser(user);
        RequestDispatcher view = request.getRequestDispatcher(PROFILE_UPDATE);
        view.forward(request, response); //reload admin page with updated table

    }

}
