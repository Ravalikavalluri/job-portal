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
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ViewUser")
public class MyProfile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    UserDao userDao = new UserDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
        try {
            handleRequestForViewUser(request, response);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    private void handleRequestForViewUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        UserDto user = userDao.getUser(request.getParameter("email"));
        RequestDispatcher dispatcher;

        request.setAttribute("user", user);
        request.setAttribute("email", request.getParameter("email"));
        dispatcher = request.getRequestDispatcher("/StudentInfo.jsp");
        dispatcher.forward(request, response);

    }
}
