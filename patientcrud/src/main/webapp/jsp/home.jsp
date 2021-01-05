<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Patient Home</title>
</head>
<body>
	<div align="center">
		<h1>Patient List</h1>

		<table border="1">
			<th>Name</th>
			<th>Age</th>
			<th>Description</th>
			<th>Creation Time</th>
			<th>Updation Time</th>

			<c:forEach var="patient" items="${listPatient}" varStatus="status">
				<tr>
					<td>${patient.patient_name}</td>
					<td>${patient.patient_age}</td>
					<td>${patient.description}</td>
					<td>${patient.creation_ts}</td>
					<td>${patient.updation_ts}</td>
					<td><a href="updatePatient?id=${patient.patient_id}">update</a>
						<a href="deletePatient?id=${patient.patient_id}">Delete</a>
					</td>

				</tr>
			</c:forEach>
				<a href="addPatient">New Patient</a>
		</table>
	</div>
</body>
</html>