<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To Do List</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<header class="header_section">
		<div class="rotated_head_title">나의 해야할 일들</div>
		<div class="register_new_todo">
			<a href="/todoForm.jsp">새로운 TODO 등록</a>
		</div>
	</header>
	<section class="list_section">
		<article class="list">
			<div class="category_title">TODO</div>
		</article>
		<article class="list">
			<div class="category_title">DOING</div>
		</article>
		<article class="list">
			<div class="category_title">DONE</div>
		</article>
	</section>
</body>
</html>