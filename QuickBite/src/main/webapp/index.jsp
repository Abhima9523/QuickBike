<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<%-- <h2>Hello World!</h2>
<h1>${name }</h1>
<h1>${email }</h1> --%>
<!-- <h1> data saved sucessfully</h1> -->
<table>
<tr>
<th>Id</th>
<th>Name</th>
<th>Role</th>
<th>Email</th>
<th>Password</th>

</tr>
<c:forEach var="user" items="${us }">
<tr>
<td>${user.id}</td>
<td>${user.name}</td>
<td>${user.role}</td>
<td>${user.email}</td>
<td>${user.password}</td>

</tr>
</c:forEach>
</table>

</body>
</html><html>
<body>
<h2><%= "Hello World!" %></h2>
</body>
</html>
