<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Users</title>
</head>
<body>
	<c:if test="${!empty users}">

		<table border="1">
			<tr>
				<th>User Name</th>
				<th>User Role</th>
			</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td><c:out value="${user.userName}" /></td>
					<td><c:out value="${user.userRole}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<tr>
		<td><a href="/AddTPC/InsertUser">Assign TPC and Tasks</a></td>
	</tr>
	<tr>
		<td><a href="/AddTPC/">Home</a></td>
	</tr>
	<tr>
		<td><a href="/AddTPC/DeleteUser">Remove TPC</a></td>
	</tr>

</body>
</html>