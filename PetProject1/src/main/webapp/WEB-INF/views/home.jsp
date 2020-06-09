<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
table {
	border-spacing: 0;
	width: 50%;
	border: 5px solid #ddd;
	align-self: center;
}

th, td {
	text-align: left;
	padding: 16px;
}

tfoot, tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
</head>
<body>
	${message}
	
			<p><a href=getpets>Home</a> <a href=idpets>My pets</a> <a
				href=addpet>Add pet</a> <a href=logout>Logout</a></p>
		
	<table align="center">
		
		<tr>
			<th>ID</th>
			<th>PET_NAME</th>
			<th>PET_AGE</th>
			<th>PET_PLACE</th>
			<th>PET_OWNERID</th>
			<th>Action</th>

		</tr>
		<c:forEach var="s" items="${petlist }">
			<tr>
				<td>${s.getId()}</td>
				<td>${s.getPet_name()}</td>
				<td>${s.getPet_age()}</td>
				<td>${s.getPet_place()}</td>
				<td>${s.getPet_ownerid()}</td>
				<td><c:choose>
						<c:when test="${s.getPet_ownerid() == 0}">
							<a href="buypet?petid=${s.getId()}">
								<button type="button">buy</button>
							</a>
						</c:when>
						<c:otherwise>
							<button type="button">sold</button>

						</c:otherwise>
					</c:choose>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
