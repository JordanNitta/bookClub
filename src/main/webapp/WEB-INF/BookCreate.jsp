<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container mt-4">
		<div class="d-flex justify-content-between">
			<h2>Add a Book to Your Shelf!</h2>
			<a href="/books">back to the shelves</a>
		</div>
			<div class="row justify-content-center mt-5">
				<div class="col-md-6">
					<form:form action="/process/book/create" method="POST"
						modelAttribute="newBook">
					<form:input type="hidden" path="user" value="${user_id}"/>
						<div class="form-group">
							<form:label path="title">Title:</form:label>
							<form:input type="text" class="form-control" path="title" />
							<form:errors path="title" cssClass="text-danger" />
						</div>
						<div class="form-group">
							<form:label path="author">Author:</form:label>
							<form:input type="text" class="form-control" path="author" />
							<form:errors path="author" cssClass="text-danger" />
						</div>
						<div class="form-group">
							<form:label path="myThought">My Thought:</form:label>
							<form:input type="text" class="form-control" path="myThought" />
							<form:errors path="myThought" cssClass="text-danger" />
						</div>
						<button type="submit" class="btn btn-primary mt-2">Register</button>
					</form:form>
				</div> 
			</div>
	</div>
</body>
</html>