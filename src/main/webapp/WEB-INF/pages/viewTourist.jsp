<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
	<h2>Tourist details</h2>

	<p>${message}</p>
	<table>
		<tr>
			<td>Last Name</td>
			<td>${tourist.lastName}</td>
		</tr>
		<tr>
			<td>First name</td>
			<td>${tourist.firstName}</td>
		</tr>
		<tr>
			<td>Email</td>
			<td>${tourist.email}</td>
		</tr>
		<tr>
			<td>Language</td>
			<td>${emp.language}</td>
		</tr>
		<tr>
			<td>Phone</td>
			<td>${tourist.phone}</td>
		</tr>
	</table>
<a href="<c:url value="/register"/>">Add tourist</a>
<a href="<c:url value="/listTourists"/>">View all</a>
</body>
</html>
