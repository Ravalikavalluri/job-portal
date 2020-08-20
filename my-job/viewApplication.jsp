<%@page import="com.dao.util.JobApplicationDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<style>
body {
  background-image: url('image6.png');
}
tr:hover {background-color:gray;}
</style>
<%

        ArrayList<JobApplicationDto> applications =(ArrayList<JobApplicationDto>) request.getAttribute("applications");
    %>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2  align="center">View Applied Jobs</h2>
<table border="1" align="center" style="background-color: #D6DBDF ">
        <thead>
            <tr>
                <th>ApplicationId</th>
                <th>EmailID</th>
                <th>CompanyName</th>
                <th>JobTitle</th>
                <th>JobDescription</th>
                <th>Job Pay</th>

            </tr>
        </thead>
        <tbody>
            <% for(int i = 0; i < applications.size(); i++) {
                JobApplicationDto Jobapplication = new JobApplicationDto();
                Jobapplication = applications.get(i);
                //out.println(actor.getId());
                //out.println(actor.getFirstname());
                //out.println(actor.getLastname());
            %>

<tr>
                <td><%=i+1%></td>
                <td><%=Jobapplication.getEmailID()%></td>
                <td><%=Jobapplication.getCompanyname()%></td>
                <td><%=Jobapplication.getJobTitle()%></td>
                <td><%=Jobapplication.getJobDesc()%></td>
                <td><%=Jobapplication.getJobpay()%></td>

               </tr>

           
            <%
            };
            %>
        </tbody>
    </table>
</body>
</html>