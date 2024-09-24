<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.option-container {
	/* 	margin: 0; */
	display: flex;
	justify-content: center;
	border-bottom: 2px solid #e0e0e0;
}

select {
	color: #004379;
	padding: 10px;
	border: 1px solid #34499ec0;
	border-radius: 5px;
	margin-top: 15px;
	margin-bottom: 15px;
	font-size: 16px;
	width: 10vw;
	margin-bottom: 15px;
}
            
.event-container {
	margin: 5px;
	height: 60vh;
}

.individual-event {
	text-align: left;
	width: 50vw;
	padding: 0.1em 1em;
	margin-left: 24vw;
	margin-bottom: 3vh;
	background-color: #ffffff;
	border-radius: .75rem;
	color: #34499ec0;
	box-shadow: 0 1em 3em rgba(0, 0, 0, .175);
}

span {
	color: #004379;
	font-weight: 700;
}
</style>
</head>
<body>
	<div class="option-container">
		<f:select path="cityValidator" onchange="citySelect(this.value)">
			<f:option value="Select City" label="Select City: "  ></f:option>
			<c:forEach items="${cities}" var="city">
				<f:option value="${city}" label="${city}" onclick="citySelect()"></f:option>
			</c:forEach>
		</f:select>
	</div>

	<div class="event-container">
		<c:if test="${events != null}">
			<c:forEach items="${events}" var="event">
				<div class="individual-event">
					<p>
						<span>Title: </span>${event.title}</p>
					<p>
						<span>Description: </span>${event.description}</p>
					<p>
						<span>Status: </span>${event.status}</p>
				</div>
			</c:forEach>
		</c:if>
	</div>

	<script type="text/javascript">
		function citySelect(city) {
			window.location.href = "http://localhost:8080/Event-Management-System?cityParam="
					+ city;
		}
	</script>
</body>
</html>