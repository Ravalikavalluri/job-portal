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
<body style="background-color:white;">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Job Portal</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="thestyles.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<h1 style="color:black;" align="center"> Welcome To Job Portal </h1>
	<div id="container">
	
	<!-- Login Container -->
		<div align="center" id="loginBox" style= "background-color: #CB4335 ">
			<form action='Login' method="post" id="userform">
				<fieldset style= "margin:auto text-align:center">
				<legend class="legend-bold" >Login</legend>
					<div>					
						<label>Email:</label>
						<input class="theinput" type="text" placeholder= "Enter email" name="email" required/>
					</div>
					<div>
						<label>Password:</label>
						<input class="theinput" type="password" placeholder = "Enter password" name="psword" id= "psword" required/>
					</div>				
					<br>
					<input class="submit" type="submit" value="Login"/> 
					
				</fieldset>
				
			</form>
			<br>
			<!-- Login box Footer -->
			<div id="footer2">
				<p style="color:black"> New? <a href="#registerModal" id="registerLink" style="color:#CB4335">Register</a></p>

			</div>
		</div>
		<!-- Modal for registration-->
	  	<div class="modal fade" id="registerModal" role="dialog" >
			<div style="text-align: center" class="modal-dialog" >
		    
		    	 <!-- Modal content-->
			      <div class="modal-content">
				       <div class="modal-header" style="background-color: #CB4335">
				        <button type="button" class="close" data-dismiss="modal" style="background-color: #CB4335" >&times;</button>
				        <h4 style="background-color: #CB4335"> Register </h4>
				       </div>
				       <!-- Modal body-->
				       <div class="modal-body" style="padding:30px 40px; ">
				       <!-- Register Form -->
				        <form action='Register' method="post" id="regform">
							<fieldset style= "margin:auto text-align:center">
							<div>
                            		<label for="fname">FIRST NAME</label>
                            		<input class="theinput" type="text" name="fname" id="fname" placeholder="Enter First name" required/>
                            </div>
                            <div>
                                     <label for="lname">LAST NAME</label>
                                     <input class="theinput" type="text" name="lname" id="lname" placeholder="Enter Last name" required/>
                             </div>
                             <div>
                             		 <label for="usnm">Username</label>
                             		 <input class="theinput" type="text" name="usnm" id="usnm" placeholder="Enter Username" required/>
                             </div>
                            <div>
                            		<label for="dob">DOB</label>
                            		<input class="theinput" type="date" name="dob" id="dob" placeholder="mm/dd/yyyy" pattern="\d{4}-\d{2}-\d{2}" required/>
                             </div>
                            <div>
                            <label for="phoneNo">Phone Number</label>

                            <input class="theinput" type="tel" name="phoneNo" id="phoneNo" placeholder="(888)888-8888" required/>

                            </div>

								<div>
									<label for="eml">Email</label>
									<input class="theinput" type="text" name="eml" id="eml" placeholder="Enter Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required/>
								</div>			
								<div>
									<label for="psword">Password</label> 
									<input class="theinput" type="password" id="psword" name="psword" placeholder="Enter Password" required/>
								</div>			
								<div>
									<label for="cfmpsword">Confirm Password</label> 
									<input class="theinput" type="password" id="cfmpsword" placeholder="Confirm Password" required/>
								</div> 
								<br>
								<input class="submit" type="submit" value="Register"/> 
							</fieldset>				
						</form>
						</div>
						<!-- Modal footer-->
						<div class="modal-footer" style="background-color: #CB4335">
					          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal" ><span class="glyphicon glyphicon-remove"></span> Cancel</button>
					    </div>					
				</div>
			</div>
	  	</div>
	  	
	 	<script>
			$(document).ready(function(){
				//JQuery confirms password is equal to confirm password field
				$("#regform").validate({
					rules: {
						cfmpsword :
						{
							equalTo: "#psword"
						}
					}
				});
				//opens modal when user clicks register
				$("#registerLink").click(function(){
			        $("#registerModal").modal();
			    });
			});


		</script>
	</div>
	<!-- page Footer -->
	<div id="footer"></div>
</body>
</html>