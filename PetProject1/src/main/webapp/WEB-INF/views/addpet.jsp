<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<style>
table {
	
	border-spacing: 0;
	width: 50%;
	border: 5px solid #ddd;
	padding: 16px;
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
<a href="getpets">Home</a>
<a href="addpet">Add pet</a>
<a href="logout">Logout</a><br>

<form action="savepet">
<table>
<tr>
<td>
Name   <input type="text" name="petname"><br>
Age    <input type="number" min="0" max="99" name="age"><br>
place  <input type="text" name=place><br>
<input type="submit" value="save"><input type="reset" value="cancel">
</td>
</tr>
</table>
</form>
</body>
</html>
