<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up Page</title>
<style>
* {
	margin: 0;
	padding: 0;
}

body {
	background-color: #f0f0f0;
	font-family: helvetica;
}

a {
	display: block;
	color: #ad5482;
	text-decoration: none;
	font-weight: bold;
	margin-top: 40px;
	text-align: center;
}

#bg {
	position: relative;
	top: 20px;
	height: 600px;
	width: 800px;
	background: url('https://i.imgur.com/3eP9Z4O.png') center no-repeat;
	background-size: cover;
	margin-left: auto;
	margin-right: auto;
	border: #fff 15px solid;
}

.module {
	position: relative;
	top: 15%;
	height: 70%;
	width: 450px;
	margin-left: auto;
	margin-right: auto;
	border-radius: 5px;
	background: RGBA(255, 255, 255, 1);
	-webkit-box-shadow: 0px 0px 15px 0px rgba(0, 0, 0, .45);
	box-shadow: 0px 0px 15px 0px rgba(0, 0, 0, .45);
}

.module ul {
	list-style-type: none;
	margin: 0;
}

.tab {
	float: left;
	height: 60px;
	width: 25%;
	padding-top: 20px;
	box-sizing: border-box;
	background: #eeeeee;
	text-align: center;
	cursor: pointer;
	transition: background .4s;
}

.tab:first-child {
	-webkit-border-radius: 5px 0px 0px 0px;
	border-radius: 5px 0px 0px 0px;
}

.tab:last-child {
	-webkit-border-radius: 0px 5px 0px 0px;
	border-radius: 0px 5px 0px 0px;
}

.tab:hover {
	background-color: rgba(0, 0, 0, .1);
}

.activeTab {
	background: #fff;
}

.activeTab .icon {
	opacity: 1;
}

.icon {
	height: 24px;
	width: 24px;
	opacity: .2;
}

.form {
	float: left;
	height: 86%;
	width: 100%;
	box-sizing: border-box;
	padding: 40px;
}

.textbox {
	height: 50px;
	width: 100%;
	border-radius: 3px;
	border: rgba(0, 0, 0, .3) 2px solid;
	box-sizing: border-box;
	padding: 10px;
	margin-bottom: 30px;
}

.textbox:focus {
	outline: none;
	border: rgba(24, 149, 215, 1) 2px solid;
	color: rgba(24, 149, 215, 1);
}

.button {
	height: 50px;
	width: 100%;
	border-radius: 3px;
	border: rgba(0, 0, 0, .3) 0px solid;
	box-sizing: border-box;
	padding: 10px;
	margin-bottom: 30px;
	background: #90c843;
	color: #FFF;
	font-weight: bold;
	font-size: 12pt;
	transition: background .4s;
	cursor: pointer;
}

.button:hover {
	background: #80b438;
}
</style>

<script type="text/javascript">
function SignUpValidation()
{
	var password = document.getElementById("password").value;
	var email = document.getElementById("email").value;
	var confirmpassword = document.getElementById("confirmpassword").value;
	var contact = document.getElementById("contact").value;
	
	var status = false;
	var p=1;
	var e=1;
	var cp=1;
	var c=1;
	var match=1;
	
	if(email.length == 0)
	{
		alert("Email is Mandatory");
	}
	else
	{
		p=0;
	}
	if(contact.length == 0 )
	{
		alert("Contact is Mandatory");
	}
	else
	{
		c=0;
	}
	if(password.length == 0 )
	{
		alert("Password is Mandatory");
	}
	else if(password.length < 8)
	{
		alert("Password length must be 8 characters minimum");
	}
	else
	{
		e=0;
	}
	if(confirmpassword.length == 0 )
	{
		alert("Confirm Password is Mandatory");
	}
	else
	{
		cp=0;
	}
	
	
	if(confirmpassword == password)
	{
		match=0;
	}
	else
	{
		alert("Password Mismatch");
	}
	
	if(e==0 && c==0 && p==0 && cp==0 && match==0)
	{
		status = true;
	}
	
	return status;
	
}


</script>


</head>
<body>


	<div id="bg">
		<center>
			<h1>Register here</h1>
		</center>
		<div class="module">

			<form method="post" class="form" action="CheckGuestController"
				onSubmit="return SignUpValidation()">

				<input type="email" name="email" id="email"  placeholder="Your Email"
					class="textbox" /> 
					<input type="text" name="contact" id="contact"
					placeholder="Contact Number" class="textbox" /> 
					<input
					type="password" name="password"  id="password"
					placeholder=" Your password" class="textbox" /> <input
					type="password" name="confirmpassword" id="confirmpassword"
					placeholder=" Re-enter Your password" class="textbox" /> <input
					type="submit" name="signup" value="signup" class="button" />
			</form>
		</div>
	</div>






</body>
</html>