<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign TPC</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>



<!-- /* .box {
	display: none;
} */ -->
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
		$(document).ready(function(){
			$('input[type="radio"]').click(function(){
				if($(this).attr("value")=="Faculty"){
					$(".box").not(".Faculty").hide('fast');
					$(".Faculty").show('slow');
				}
				if($(this).attr("value")=="Student"){
					$(".box").not(".Student").hide('fast');
					$(".Student").show('slow');
				}
			});
		});
		</script> -->
</head>
<body>
	<h2>Assign TPC</h2>
	<form:form method="POST" action="/AddTPC/SubmitInsertUser">
		<table>
			<tr>
				<td><form:label path="username">User name:</form:label></td>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="role_id">User Role:</form:label></td>
				<td><form:radiobutton path="role_id" value="1" />
					Student-TPC <form:radiobutton path="role_id" value="2" />
					Faculty-TPC</td>
				<td><form:errors path="role_id" cssClass="error" /></td>
			</tr>
			<%-- <!-- <div id="login-error" class="control-group"> -->
			<div class="Faculty box">
				<form:input path="userName" /><br>
				</br><form:input path="userWork"/>
			</div>

			<div class="Student box">
				<form:input type="text"  path="userName"/><br>
			</div> --%>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>


		</table>
	</form:form>
	
	
</body>
</html>
