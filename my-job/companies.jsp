<%@page import="com.dao.util.CompanyDto"%>
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
</style>
 <%

        ArrayList<CompanyDto> companies =(ArrayList<CompanyDto>) request.getAttribute("companies");
    %>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2  align="center">Companies List</h2>
<table border="1" align="center" style="background-color: #D6DBDF " >


<div id="main">
<button onclick="history.back()"   >Back</button>

</div>
<style>
main {
  width: 200px;
  border: 1px dotted black;

}
h1 {
  margin: 0;
    display: inline-block;
}
button {
  float: Topleft;
}
tr:hover {background-color:gray;}

</style>
        <thead>
            <tr>

                <th>Company Name</th>
                <th>Job Title</th>
                <th>Job Description</th>
                <th>Job Pay</th>

            </tr>
        </thead>
        <tbody>
            <% for(int i = 0; i < companies.size(); i++) {
                CompanyDto company = new CompanyDto();
                company = companies.get(i);
                //out.println(actor.getId());
                //out.println(actor.getFirstname());
                //out.println(actor.getLastname());
            %>


            <tr>

                <td><%=company.getCompanyName()%></td>
                <td><%=company.getJobtitle()%></td>
                <td><%=company.getJobdesc()%></td>
                <td><%=company.getPay()%></td>

                <td>
                	<form action="./JobApplication" method="post">
                	


                	<input type="text" name="companyName" hidden="true" value="<%=company.getCompanyName()%>">
                	<input type="text" name="jobtitle" hidden="true" value="<%=company.getJobtitle()%>">
                	<input type="text" name="jobdesc" hidden="true" value="<%=company.getJobdesc()%>">
                	<input type="text" name="pay" hidden="true" value="<%=company.getPay()%>">


                	<input type="text" name="email" value="${email}" hidden="true">
                	<input name="jobID" value="<%=company.getJobID()%>" hidden="true">
                	<input name="companyID" value="<%=company.getCompanyID()%>" hidden="true">

                	  	<button onclick="myFunction()" id="myButton" value="Apply">Apply</button>

                	  <script>
                	  function myFunction() {

                                                              var btn = document.getElementById("myButton");

                                                              if (btn.value == "Apply") {
                                                                  btn.value = "Applied";
                                                                  btn.innerHTML = "Applied";
                                                              }
                                                              else {
                                                                  btn.value = "Apply";
                                                                  btn.innerHTML = "Applied";
                                                              }

                                                          }
                       </script>
                	</form>
                
                </td>
                
               </tr>
            <%
            };
            %>
        </tbody>
    </table>
</body>
</html>