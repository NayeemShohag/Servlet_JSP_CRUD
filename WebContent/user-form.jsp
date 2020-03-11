<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Card Users List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header> <nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: blue">
	<div>
		<a href="<%=request.getContextPath()%>/"class="navbar-brand"> Card Users </a>
	</div>

	<ul class="navbar-nav">
		<li><a href="<%=request.getContextPath()%>/"
			class="nav-link text-dark">User List</a></li>
	</ul>
	</nav> </header>
	<br>
	<div class="container col-md-5">
		<div class="card text-white bg-info">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			<div class="card-header">Edit User Info</div>
            		</c:if>
						<c:if test="${user == null}">
            			<div class="card-header">Add New User</div>
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>User Name</label> <input type="text"
						value="<c:out value='${user.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Card Number</label> <input type="text"
						value="<c:out value='${user.card}' />" class="form-control"
						name="card" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>User Email</label> <input type="text"
						value="<c:out value='${user.email}' />" class="form-control"
						name="email">
				</fieldset>

				<fieldset class="form-group">
					<label>User Country</label> <input type="text"
						value="<c:out value='${user.country}' />" class="form-control"
						name="country">
				</fieldset>

				<button type="submit" class="btn btn-outline-dark btn-lg">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
