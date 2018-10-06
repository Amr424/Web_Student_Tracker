<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Tracker App</title>
<link type="text/css" rel="stylesheet" href="Css/style.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>University</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<input type="button" value="Add Student"
				onclick="window.location.href='add-student-form.jsp'; return false;"
				class="add-student-button">
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="temp" items="${STUDENT_LIST}">
					<!-- set a link for each student -->
					<c:url var="templink" value="StudentControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="studentId" value="${temp.id}" />
					</c:url>

					<c:url var="deletelink" value="StudentControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="studentId" value="${temp.id}" />
					</c:url>
					<tr>
						<td>${temp.firstName}</td>
						<td>${temp.lastName}</td>
						<td>${temp.email}</td>
						<td><a href="${templink}">Update</a> | <a
							href="${deletelink}"
							onclick="if(!(confirm('Are you Sure you want to delete this student?'))) return false">Delete</a>
						</td>
					</tr>

				</c:forEach>


			</table>
		

		</div>
	</div>

</body>
</html>