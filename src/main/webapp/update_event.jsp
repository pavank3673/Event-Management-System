<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.main-container {
	background-color: #ffffff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	max-width: 400px;
	width: 100%;
	margin-left: 33vw;
	margin-top: 10vh;
}

h1 {
	margin-top: 0;
	color: #004379;  
	text-align: center;
}

form {
	display: flex;
	flex-direction: column;
}

input {
	color: #004379;
	padding: 10px;
	border: 1px solid #ddd;
	border-radius: 4px;
	margin-bottom: 15px;
	font-size: 16px;
}

label {
	margin-bottom: 5px;
	color: #004379;
}

.address-edit-delete-container {
	margin-bottom: 10px;
}

.address-buttons {
	display: inline-block;
	text-align: center;
	color: #ffffff;
	background-color: #004379;
	text-decoration: none;
	padding: 8px 31px;
	margin: 0px 10px 0px 10px;
	border-radius: 5px;
	font-size: 16px;
	transition: background-color 0.3s ease, transform 0.3s ease;
}

.address-buttons:hover {
	background-color: #00204d;
	transform: translateY(-2px);
}

.address-buttons:active {
	background-color: #00204d;
	transform: translateY(0);
}
</style>
</head>
<body>
	<div class="main-container">
			<h1>Update Event</h1>
			<f:form action="update-event" modelAttribute="event">
				<f:label path="eventId">Event Id: </f:label>
				<f:input path="eventId" readonly="true" />
				<f:label path="title">Title: </f:label>
				<f:input path="title" />
				<f:label path="description">Description: </f:label>
				<f:input path="description" />
				<f:label path="status">Status: </f:label>
				<f:input path="status" />
				<c:if test="${event.address == null}">
					<a href="add-address-view?eventId=${event.eventId}"
						class="address-buttons">Add Address</a>
					<br>
				</c:if>
				<c:if test="${event.address != null}">
					<div class="address-edit-delete-container">
						<a
							href="request-update-address?addressId=${event.address.addressId}&eventId=${event.eventId}"
							class="address-buttons">Update Address</a> <a
							href="delete-address?addressId=${event.address.addressId}&eventId=${event.eventId}"
							class="address-buttons">Delete Address</a>
					</div>
				</c:if>
				<button type="submit" class="buttons">Update Event</button>
			</f:form>
	</div>
</body>
</html>