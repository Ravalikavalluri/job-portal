<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<style>
body {
  background-image: url('image5.png');
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Welcome <%=session.getAttribute("username")%></title>
<link rel="stylesheet" href="thestyles2.css">

</head>

<body>




<% 
//If User is not logged in redirect to home page
	if (session != null)
	{
		if(session.getAttribute("username")==null)
			response.sendRedirect("/index.jsp");
	}
%>


<div class="hero-image">
  <div class="hero-text">

<h1 align="center" style="font-size:50px">Welcome ${email}</h1><br><br>
<form action="./ViewUser" method="post">
	<input type="text" name="email" value="${email}" hidden="true">
 	<div align="center"><input class="back-home-btn" type="submit" value="My Profile" style="font-size:20px"/></div>

</form><br><br>
<form action="./ViewCompanies" method="post">
	<input type="text" name="email" value="${email}" hidden="true">
 	<div align="center"><input class="back-home-btn"  type="submit" value="Applyjob" style="font-size:20px" /></div>
</form><br><br>
<form action="./ViewJobApplication" method="post">
	<input type="text" name="email" value="${email}" hidden="true">
 	<div align="center"><input class="back-home-btn"  type="submit" value="View Applied Jobs" style="font-size:20px"/></div>
</form><br><br>


</div>
</div>

	<!-- Logout Form -->
		<form action="Logout" method="post">
					<input class="back-home-btn" type="submit" value="Logout" style="font-size:15px" >
		</form>  


</body>
</html>