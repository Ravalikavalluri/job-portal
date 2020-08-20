package com.controllers.servlet;

import com.dao.util.CompanyDto;
import com.dao.util.CompanyDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ViewCompanies")
public class ApplyJob extends HttpServlet {
    private static final long serialVersionUID = 1L;

    CompanyDao companydao = new CompanyDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyJob() {
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
            handleRequestForViewCompany(request, response);
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

    private void handleRequestForViewCompany(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String email = request.getParameter("email");

        List<CompanyDto> companies = companydao.getCompanies(email);
        RequestDispatcher dispatcher;

        request.setAttribute("companies", companies);
        request.setAttribute("email", request.getParameter("email"));
        dispatcher = request.getRequestDispatcher("/companies.jsp");
        dispatcher.forward(request, response);
    }
}
