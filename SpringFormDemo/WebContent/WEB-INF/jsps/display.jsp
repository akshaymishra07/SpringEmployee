<%@ page import="com.pojo.Employee"%>
<%@ page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ALL EMPLOYEES</title>
</head>
<body>





	<core:if test="${not empty employees}">

		<h2 align="center">LIST OF ALL THE EMPLOYEES</h2>
		<div align="center">

			<table border="1">

				<tr>
					<th>Employee Id</th>
					<th>Employee Name</th>
					<th>Salary</th>
					<th>Technology</th>
				</tr>

				<core:forEach items="${employees}" var="emp">

					<tr>
						<td>${ emp.empId}</td>
						<td>${ emp.name}</td>
						<td>${ emp.salary}</td>
						<td>${ emp.technology}</td>
						
					</tr>


				</core:forEach>

				




			</table>
        
        </core:if>
        
        
        

 
     




		</div>
</body>
</html>