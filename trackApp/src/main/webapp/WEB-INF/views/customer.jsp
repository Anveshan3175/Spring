<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Person Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/common.css" />
</head>
<body>
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<div id="logout" align="right">
		<a href="<c:url value='${logoutUrl}' />">Logout</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
	<h3>Customers</h3>
	<div id="search">
	<c:url var="searchCustomer" value="/searchCustomer"></c:url>
		<form:form action="${searchCustomer}" commandName="customer" method="GET">
			<form:input path="id" /> &nbsp;&nbsp;&nbsp;
			<input type="submit" value="Go"> &nbsp;&nbsp;&nbsp;
			<input type="button" value="New">
		</form:form>
	</div>

<p/>
	<div id="custListDiv">
		<h3>Customers List</h3>
		<c:if test="${!empty listCustomers}">
			<table class="tg">
				<tr>
					<th width="80">Customer ID</th>
					<th width="120">First Name</th>
					<th width="120">Last Name</th>
					<th width="120">Phone</th>
					<th width="120">Email</th>
					<th width="120">City</th>
					<th width="60">Edit</th>
					<th width="60">Delete</th>
				</tr>
				<c:forEach items="${listCustomers}" var="customer">
					<tr>
						<td>${customer.id}</td>
						<td>${customer.fName}</td>
						<td>${customer.lName}</td>
						<td>${customer.city}</td>
						<td>${customer.email}</td>
						<td>${customer.city}</td>
						<td><a href="<c:url value='/edit/${customer.id}' />">Edit</a></td>
						<td><a href="<c:url value='/remove/${customer.id}' />">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	<p/>
	<div id="newCust">
		<c:url var="addAction" value="/addCustomer"></c:url>
		<form:form action="${addAction}" commandName="customer">
			<table >
				<tr>
					<td><form:label path="fName">
							<spring:message text="First Name" />
						</form:label></td>
					<td><form:input path="fName" /></td>
				</tr>
				<tr>
					<td><form:label path="lName">
							<spring:message text="Last Name" />
						</form:label></td>
					<td><form:input path="lName" /></td>
				</tr>
				<tr>
					<td><form:label path="city">
							<spring:message text="City" />
						</form:label></td>
					<td><form:input path="city" /></td>
				</tr>
				<tr>
					<td><form:label path="email">
							<spring:message text="Email" />
						</form:label></td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td><form:label path="phone">
							<spring:message text="Phone" />
						</form:label></td>
					<td><form:input path="phone" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
					value="<spring:message text="Add Person"/>" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>