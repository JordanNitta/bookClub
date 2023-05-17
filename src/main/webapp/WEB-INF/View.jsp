<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container d-flex justify-content-between">
		<h3>Welcome, <c:out value="${user.userName}" /></h1>
		<a href="/logout">Log Out</a>
	</div>
	<div class="container d-flex justify-content-between mt-3">
		<h5>Books from everyone's shelves:</h5>
		<a href="/books/new">+ Add a book to my shelf!</a>
	</div>
  <table class="table table-striped dark-table">
    <thead class="thead-dark">
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Author Name</th>
            <th>Posted By</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="book" items="${allBooks}">
            <tr>
                <td><c:out value="${book.id}" /></td>
                <td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
                <td><c:out value="${book.author}" /></td>
                <td><c:out value="${book.user.userName}" /></td>
            </tr>
        </c:forEach>
    </tbody>
  </table>
</body>
</html>