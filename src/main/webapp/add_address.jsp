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
	margin-left: 33vw;
	margin-top: 7vh;
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
			<h1>Add Address</h1>
			<f:form action="add-address?eventId=${eventId}"
				modelAttribute="address">
				<f:label path="addressLine">AddressLine: </f:label>
				<f:input path="addressLine" />
				<f:label path="landmark">landmark: </f:label>
				<f:input path="landmark" />
				<f:label path="city">City: </f:label>
				<f:input path="city" />
				<f:label path="state">State: </f:label>
				<f:input path="state" />
				<f:label path="pincode">Pincode: </f:label>
				<f:input path="pincode" />
				<button type="submit" class="buttons">Add Address</button>
			</f:form>
	</div>
</body>
</html>