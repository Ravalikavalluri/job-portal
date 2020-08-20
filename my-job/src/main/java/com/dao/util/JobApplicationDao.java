package com.dao.util;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JobApplicationDao {

    Connection Conn;

    public JobApplicationDao(){

        Conn= DBUtil.getConnection();//connect to database
    }

    public List<JobApplicationDto> getApplications(String emailID) {
        List<JobApplicationDto> applications = new ArrayList<JobApplicationDto>();
        try {
        Conn = DBUtil.getConnection();
        Statement stmt = Conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from  applied_jobs where emailID='" + emailID + "'");
        while (rs.next()) {
            JobApplicationDto application = new JobApplicationDto();
            application.setApplicationID(rs.getInt(1));
            application.setEmailID(rs.getString(2));
            application.setCompanyname(rs.getString(3));
            application.setJobTitle(rs.getString(4));
            application.setJobDesc(rs.getString(5));
            application.setJobpay(rs.getFloat(6));
            application.setJobID(rs.getInt(7));
            application.setCompanyID(rs.getInt(8));

            applications.add(application);
        }
        } catch(SQLException e)
        {
            e.printStackTrace();
        }

        return applications;
    }

    public JobApplicationDto getApplication(String emailID) {
        JobApplicationDto application = new JobApplicationDto();
        try {
        Conn = DBUtil.getConnection();
        Statement stmt = Conn.createStatement();
        ResultSet rs = stmt.executeQuery("Select * from  applied_jobs where EmailID='" + emailID + "'");
        while (rs.next()) {
            application.setApplicationID(rs.getInt(1));
            application.setEmailID(rs.getString(2));
            application.setCompanyname(rs.getString(3));
            application.setJobTitle(rs.getString(4));
            application.setJobDesc(rs.getString(5));
            application.setJobpay(rs.getFloat(6));
            application.setJobID(rs.getInt(7));
            application.setCompanyID(rs.getInt(8));
        }
        } catch(SQLException e)
        {
            e.printStackTrace();
        }
        return application;
    }

    public String insertJobapplication(JobApplicationDto application) {
        String status = "failed";

        try {
            JobApplicationDto dbApplication = getApplication(application.getEmailID());
            Conn = DBUtil.getConnection();
            Statement stmt = Conn.createStatement();
            String insertsql = "INSERT INTO  applied_jobs (emailID,CompanyName,jobtitle,jobdesc,pay,jobID,companyID) VALUES('" + application.getEmailID() + "','" + application.getCompanyname() + "','" + application.getJobTitle() + "','" + application.getJobDesc() + "'," + application.getJobpay() + "," + application.getJobID() + "," + application.getCompanyID()+ ")";
            System.out.println(insertsql);
            stmt.executeUpdate(insertsql);
            status = "success";
        } catch(SQLException e)
        {
            e.printStackTrace();
        }
        return status;
    }


}

