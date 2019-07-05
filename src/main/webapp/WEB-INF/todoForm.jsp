<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Schedule</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body class="register_schedule_body">
	<header>
		<h2>할일 등록</h2>
	</header>
	<section>
		<form name="" action="" accept-charset="utf-8" method="post">
			<p>
				<label>어떤일인가요?</label>
			</p>
			<p>
				<input type="text" name="schedule" placeholder="Swift 공부하기(24자까지)"
					maxlength="24" required>
			</p>
			<p>
				<label>누가 할일인가요?</label>
			</p>
			<p>
				<input type="text" name="name" placeholder="홍길동">
			</p>
			<p>
				<label>우선순위를 선택하세요</label>
			</p>
			<p>
				<input type="radio" name="priority" value="1">1순위
				<input type="radio" name="priority" value="2">2순위
				<input type="radio" name="priority" value="3">3순위
			</p>
			<div>
				<article class="previous_page">
					<a href="./main.jsp">&lt; 이전</a>
				</article>
				<article class="buttons">
					<input type="submit" value="제출">
					<input type="reset" value="내용지우기">
				</article>
			</div>
		</form>
	</section>
</body>
</html>