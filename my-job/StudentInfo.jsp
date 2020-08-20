<%@page import="com.dao.util.UserDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<style>
body {
  background-image: url('image5.png');
}
</style>
<%

		UserDto user =(UserDto) request.getAttribute("user");
    %>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<h2  align="center">User Details</h2>
<form action="./ProfileUpdatePage" method="post">
			<table align="center" class="hovertable" border='0' cellspacing='0' cellpadding='0'  bgcolor="white">


			<tr style="background-color: #F1948A ">
            					<td>FIRST NAME:</td>
            					<td align="center"><input type="text" name="firstName" value="<%=user.getFirstName()%>" style="font-size:20px"></td>
            				</tr>

            <tr style="background-color: #F1948A">
                            					<td>LAST NAME:</td>
                            					<td align="center"><input type="text" name="lastName" value="<%=user.getLastName()%>" style="font-size:20px"></td>
                            				</tr>

            <tr style="background-color:#F1948A">
                                            				<td>EMAIL ID:</td>
                                            				<td align="center"><input type="text" name="email" value="<%=user.getEmailID()%>" style="font-size:20px"></td>
                                            			</tr>
             <tr style="background-color: #F1948A">
             <td>PASSWORD: &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;</td>
             <td align="center"><input type="password" name="password" value="<%=user.getPassword()%>" style="font-size:20px"></td>
             </tr>

<tr style="background-color: #F1948A">
<td> MOBILE NUMBER:</td>
<td align="center"><input type="tel" id="phoneNo" name="phoneNo" value="<%=user.getPhoneNo()%>" style="font-size:20px"></td>
</tr>
<tr style="background-color: #F1948A">
<td> DOB:</td>
<td align="center"><input type="dob" id="dob" name="dob" value="<%=user.getDob()%>" style="font-size:20px"></td>
</tr>
<tr style="background-color: #F1948A ">
<td>CGPA:</td>
<td align="center"><input type="text" name="cgpa" value="<%=user.getCgpa()%>" style="font-size:20px"></td>
</tr>
<tr style="background-color:#F1948A ">
<td>EXPERIENCE:</td>
<td align="center"><input type="text" name="exp" value="<%=user.getExp()%>" style="font-size:20px"></td>
</tr>
<tr style="background-color: #F1948A ">
<td> BIO:</td>
<td align="center"><input type="text" id="bio" name="bio" value="<%=user.getBio()%>" style="font-size:20px"></td>
</tr>



					<td><input type="submit" style="background-color: #27AE60 " value="UPDATE" align="center" style="font-size:30px" > </td>
				</tr>
			</table>
			</form>
</body>
</html>