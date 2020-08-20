package com.controllers.servlet;

import com.dao.util.JobApplicationDto;
import com.dao.util.JobApplicationDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "JobApplication", urlPatterns = { "/JobApplication" }) //set in web.xml
public class ApplyJobSuccessPage extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String SUCCESSFUL= "/successful.jsp";
    private JobApplicationDao dao;

    public ApplyJobSuccessPage() {
        super();
        dao = new JobApplicationDao(); //create new data object

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        JobApplicationDto applicationDto = new JobApplicationDto();	//create new user object
        PrintWriter pwOut= response.getWriter();

        //get input from jsp and store it in user object

        String email=request.getParameter("email");
        String companyName =request.getParameter("companyName");
        String jobTitle=request.getParameter("jobtitle");
        String jobDesc = request.getParameter("jobdesc");
        int jobId = Integer.parseInt(request.getParameter("jobID"));
        int companyId = Integer.parseInt(request.getParameter("companyID"));
        float jobPay = Float.parseFloat(request.getParameter("pay"));



        applicationDto.setEmailID(email);
        applicationDto.setCompanyname(companyName);
        applicationDto.setJobTitle(jobTitle);
        applicationDto.setJobDesc(jobDesc);
        applicationDto.setJobpay(jobPay);
        applicationDto.setJobID(jobId);
        applicationDto.setCompanyID(companyId);





        String status = dao.insertJobapplication(applicationDto);
        request.setAttribute("status",status);
        request.setAttribute("applications",dao.getApplications(email));
            RequestDispatcher view = request.getRequestDispatcher(SUCCESSFUL);
            view.forward(request, response); //reload admin page with updated table

    }

}
