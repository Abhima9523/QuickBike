<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>		
<head>
<meta charset="ISO-8859-1">
<title>View Page</title>
</head>
<body>
<table border="1px">
<tr>
<th>Id</th>
<th>Name</th>
<th>Email</th>
<th>Password</th>
<th>Role</th>
<th>delete</th>
<th>edit</th>
</tr>
<c:forEach var="user" items="${us}">
<tr>
<td>${user.id}</td>
<td>${user.name}</td>
<td>${user.email}</td>
<td>${user.role}</td>
<td>${user.password}</td>
<td><a href="delete?id=${ user.id}"><button>delete</button> </a>
<td><a href="edit?id=${ user.id}"><button>edit</button> </a>
</tr>
</c:forEach>
</table>
</body>
</html>