<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h2>Tourist list</h2>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>First name</th>
				<th>Last name</th>
				<th>Email</th>
				<th>Phone</th>
			</tr>
		<thead>
		<tbody>
			<c:forEach var="tourist" items="${list}">
				<tr>
					<td>${tourist.id}</td>
					<td>${tourist.firstName}</td>
					<td>${tourist.lastName}</td>
					<td>${tourist.email}</td>
					<td>${tourist.phone}</td>
				<tr>
			</c:forEach>
		</tbody>
	</table>
	<br/>
	<a href="<c:url value="/"/>">Home</a>
	<br/><br/>
	<a href="<c:url value="/register"/>">Create tourist</a>
</body>
</html>
