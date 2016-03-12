<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	font-size: 20px;
	color: teal;
	font-family: Calibri;
}

td {
	font-size: 15px;
	color: black;
	width: 100px;
	height: 22px;
	text-align: left;
}

.heading {
	font-size: 18px;
	color: white;
	font: bold;
	background-color: orange;
	border: thick;
}
</style>
</head>
<body>
	<center>
		<br /> <br /> <br /> <b>Being Java Guys | Registration Form </b> <br />
		<br />
		<div>
			<form action="/AddTPC/SubmitInsertUser"
				method="post">
				<table border="1">
					<tr>
						<th>UserName</th>
						<td><input type="text" name="userName"
							value="${user.userName}"></td>
					</tr>
					<tr>
						<td>TPC :</td>
						<td><%-- <form:radiobuttons path="userRole"
								items="${map.TPCList}" /> --%>
							Student <input type="radio" name="userRole" value="Student">
							Faculty <input type="radio" name="userRole" value="Faculty">		
						</td>
					</tr>
					<tr>
						<th></th>
						<td><input type="submit"></td>
					</tr>
				</table>
			</form>
		</div>
	</center>
</body>
</html>
