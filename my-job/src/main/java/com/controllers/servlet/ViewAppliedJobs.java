package com.controllers.servlet;

import com.dao.util.JobApplicationDao;
import com.dao.util.JobApplicationDto;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class ViewJobApplication
 */
@WebServlet("/ViewJobApplication")
public class ViewAppliedJobs extends HttpServlet {
    private static final long serialVersionUID = 1L;

    JobApplicationDao job = new JobApplicationDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAppliedJobs() {
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
            handleRequestForViewApplications(request, response);
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

    private void handleRequestForViewApplications(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<JobApplicationDto> applications = job.getApplications(request.getParameter("email"));

        RequestDispatcher dispatcher;

        request.setAttribute("applications", applications);

        dispatcher = request.getRequestDispatcher("/viewApplication.jsp");
        dispatcher.forward(request, response);
    }
}


