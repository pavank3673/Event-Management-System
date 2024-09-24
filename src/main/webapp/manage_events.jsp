<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1 {
	text-align: center;
	margin: 0;
	padding: 20px;
	font-size: 6vv;
	color: #004379;
	border-bottom: 2px solid #e0e0e0;
}

p {
	display: flex;
	justify-content: center;
}

table {
	background-color: #ffffff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	max-width: 900px;
	width: 100%;
	margin-left: 20vw;
	margin-top: 2vh;
	text-align: left;
}

th {
	color: #004379;
	border-bottom: 2px solid #e0e0e0;
}

td {
	color: #34499ec0;
	padding: 3px 5px 3px 5px;
}
</style>
</head>
<body>
	<h1>Manage Events</h1>
	<p>
		<a href="add-event-view" class="buttons">Add Event</a>
	</p>

	<table>
		<tr>
			<th>Event Id</th>
			<th>Title</th>
			<th>Description</th>
			<th>Start DateTime</th>
			<th>Status</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:if test="${events != null}">
			<c:forEach items="${events}" var="event">
				<tr>
					<td>${event.eventId}</td>
					<td>${event.title}</td>
					<td>${event.description}</td>
					<td>${event.startDateTime}</td>
					<td>${event.status}</td>
					<td><a href="request-update-event?eventId=${event.eventId}"
						class="buttons">Edit</a></td>
					<td><a href="delete-event?eventId=${event.eventId}"
						class="buttons">Delete</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>