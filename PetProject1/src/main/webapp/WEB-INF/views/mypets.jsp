<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" style:width="50" centre:200px>
<td><a href=getpets>Home</a> <a href=idpets>My pets</a> <a
href=addpet>Add pet</a> <a href=logout>Logout</a>
<tr>
<th>ID</th>
<th>PET_NAME</th>
<th>PET_AGE</th>
<th>PET_PLACE</th>
<th>PET_OWNERID</th>

</tr>
<c:forEach var="s" items="${petlist}">
<tr>
<td>${s.getId()}</td>
<td>${s.getPet_name()}</td>
<td>${s.getPet_age()}</td>
<td>${s.getPet_place()}</td>
<td>${s.getPet_ownerid()}</td>
</tr>
</c:forEach>

</body>
</html>