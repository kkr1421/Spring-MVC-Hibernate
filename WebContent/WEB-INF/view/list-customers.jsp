<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>List customers</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">CRM - Custom Relationship Manager</div>
	</div>
	<div id="container">
		<div id="content">
			<input type="button" value="AddCustomer"
				onclick="window.location.href='showFormForAdd';return false;"
				class="add-button" />
			<form:form action="search" method="POST">
				<table style="border-style: none;width: 33%;margin-bottom:10px;">
					<tr style="background:none;border:none">
						<td>Search Customer:</td>
						<td><input type="text" name="searchInput" id="searchInput">
						</td>
						<td><input type="submit" value="Searh" class="add-button" style="margin-bottom:0px;" /></td>
					</tr>
				</table>
			</form:form>
			<table>
				<tr>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Email</td>
					<td>Action</td>
				</tr>

				<c:forEach var="tempCustomer" items="${customers}">
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}"></c:param>
					</c:url>
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}"></c:param>
					</c:url>
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td><a href="${updateLink}">Update</a> | <a
							href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delet this Customer'))) resturn fasle;">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>