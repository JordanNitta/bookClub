<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div
		class="container d-flex justify-content-between align-items-center">
		<h3>
			<c:out value="${book.title}" />
		</h3>
		<a href="/books">back to the shelves</a>
	</div>

	<div class="container mt-2">

		<div class="d-flex">
			<c:choose>
				<c:when test="${book.user.id == user_id}">

					<h5 style="color: red;">
						<c:out value="${book.user.userName}" />
					</h5>
					
					<h5 class="ml-1">read</h5>

					<h5 class="ml-1">
						
						<c:out value="${book.title}" />
						by
					</h5>

					<h5 class="ml-1 text-success">
						
						<c:out value="${book.author}" />
						.
					</h5>

				</c:when>

				<c:otherwise>

				</c:otherwise>
			</c:choose>
		</div>
			<p class="mt-3">
				Here are <c:out value="${book.user.userName}" /> Thought:
			</p>
		<hr>
		<p>
			<c:out value="${book.myThought}"></c:out>
		<p>
		<hr>

		<c:choose>
			<c:when test="${book.user.id == user_id}">
				<button type="button" class="btn btn-danger btn-lg">
					<a href="/books/${book.id}/edit">Edit</a>
				</button>

				<button type="button" class="btn btn-danger btn-lg">
					<form action="/delete/${book.id}" method="post">
						<input type="hidden" name="_method" value="delete"> <input
							type="submit" value="Delete">
					</form>
				</button>
			</c:when>
		</c:choose>
	</div>
</body>
</html>