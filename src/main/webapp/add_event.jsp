<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
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
	margin-left: 35vw;
	margin-top: 20vh;
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
</style>
</head>
<body>
	<div class="main-container">
			<h1>Add Event</h1>
			<f:form action="add-event" modelAttribute="event">
				<f:label path="title">Title: </f:label>
				<f:input path="title" />
				<f:label path="description">Description: </f:label>
				<f:input path="description" />
				<f:label path="status">Status: </f:label>
				<f:input path="status" />
				<button type="submit" class="buttons">Add Event</button>
			</f:form>
	</div>
</body>
</html>