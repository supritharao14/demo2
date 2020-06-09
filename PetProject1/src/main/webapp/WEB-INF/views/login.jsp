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
	<form action="verifylogin">
		<table align="center" width="400">
			<tr>

				<td align="right"><a href="log">Login</a> <a href="register">Register</a></td>
			</tr>
			<tr>
				<th>Login</th>
				<td></td>
			</tr>
			<tr>
				<td>UserName <input type="text" name="name" required="required"><br>
					<br> Password <input type="password" name="password"><br>
					<br> <input type="submit" value="Login"><input
					type="reset" name="reset"></td>
			</tr>
		</table>


	</form>
</html>
