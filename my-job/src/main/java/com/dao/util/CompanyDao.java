package com.dao.util;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDao {
    Connection Conn;

    public CompanyDao() {

        Conn= DBUtil.getConnection();//connect to database
    }


    public List<CompanyDto> getCompanies(String email) throws SQLException {
        List<CompanyDto> companies = new ArrayList<CompanyDto>();
        Conn = DBUtil.getConnection();;
        Statement stmt = Conn.createStatement();
        String query = "select  company_details .* from  company_details   LEFT OUTER JOIN  applied_jobs ON ( applied_jobs.companyID= company_details .companyID AND  applied_jobs.jobID= company_details .jobID AND  applied_jobs.emailID='"+email+"') WHERE  applied_jobs.applicationID IS NULL";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            CompanyDto company = new CompanyDto();
            company.setCompanyID(rs.getInt(1));
            company.setCompanyName(rs.getString(2));
            company.setJobtitle(rs.getString(3));
            company.setJobdesc(rs.getString(4));
            company.setPay(rs.getInt(5));
            company.setJobID(rs.getInt(6));
            companies.add(company);

        }
        return companies;
    }

    public CompanyDto getCompany(String companyName) throws SQLException {
        CompanyDto company = new CompanyDto();
        Conn = DBUtil.getConnection();
        Statement stmt = Conn.createStatement();
        ResultSet rs = stmt.executeQuery("Select * from  company_details  where CompanyName='" + companyName + "'");
        while (rs.next()) {
            company.setCompanyID(rs.getInt(1));
            company.setCompanyName(rs.getString(2));
            company.setJobtitle(rs.getString(3));
            company.setJobdesc(rs.getString(4));
            company.setPay(rs.getInt(5));
            company.setJobID(rs.getInt(6));

        }
        return company;
    }


}

