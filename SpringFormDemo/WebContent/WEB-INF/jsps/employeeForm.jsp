<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
   
   <form:form  modelAttribute="employee" method="POST"  action="addEmployee_valid.htm">
   
   
             ID   : <form:input path="empId" size="30" />
                    <font color="red"><form:errors path="empId" /></font>
                    
             <br><br>
             Name : <form:input path="name"/>
                    <font color="red"><form:errors path="name" /></font>
                    
             
             <br><br>
             Salary : <form:input path="salary"/>
                      <font color="red"><form:errors path="salary" /></font>
                      
             <br><br>
             
             Technology : <form:select path="technology">
					<form:options items="${technologyList }"/>
				</form:select>
                <br><br>
          
             <input type="submit" value = "Add Employee">    
     
    
   
   </form:form>

</body>
</html>