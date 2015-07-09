
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<h2>Starting point</h2>
	
	<h4>Search tourist by last name</h4>
	<form:form method="POST" action="searchTourist" commandName="searchTouristCommand">
		<table>
			<tr>
				<td><form:label path="lastName">Last Name : </form:label></td>
				<td><form:input type="text" name="searchParameter" path="lastName"/></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Search" /></td>
			</tr>
		</table>
	</form:form>
	<br/>
	<a href="<c:url value="/listTourists"/>">View all tourists</a>
	<br/><br/>
	<a href="<c:url value="/register"/>">Create tourist</a>
	
</body>
</html>
