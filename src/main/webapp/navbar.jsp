<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	margin: 0;
	font-family: sans-serif;
	background-color: #f5f5f5;
}

nav {
	display: flex;
	justify-content: space-between;
	background-color: #ffffff;
	padding: 10px 20px;
	border-bottom: 1px solid #e0e0e0;
}

.logo {
	color: #263238;
	font-size: 20px;
	font-weight: bold;
	text-decoration: none;
}

.buttons {
	display: inline-block;
	color: #ffffff;
	background-color: #004379;
	text-decoration: none;
	padding: 8px 16px;
	border-radius: 5px;
	font-size: 16px;
	transition: background-color 0.3s ease, transform 0.3s ease;
}
 
.buttons:hover {
	background-color: #00204d;
	transform: translateY(-2px);
}

.buttons:active {
	-background-color: #00204d;
	transform: translateY(0);
} 
</style>
</head>
<body>
	<nav>
		<div class="logo">Event Management System</div>
		<div>
		 <c:if test="${cities != null}">
			<a href="manage-events" class="buttons">Manage Events</a>
		</c:if>
		<c:if test="${cities == null}">
			<a href="/Event-Management-System" class="buttons">Home</a>
		</c:if>
		</div>
	</nav>
</body>
</html>