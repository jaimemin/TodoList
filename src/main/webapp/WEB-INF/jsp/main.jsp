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
	<header class="headerSection">
		<div class="rotatedHeadTitle">나의 해야할 일들</div>
		<div class="registerNewTodo">
			<a href="./todo-form">새로운 TODO 등록</a>
		</div>
	</header>
	<section class="listSection">
		<div class="list">
			<div class="status">TODO</div>
			<ul id="TODO">
				<c:forEach var="todo" items="${todoList }">
					<c:if test="${todo.type == 'TODO' }">
						<li>
							<div class="todoCard">
								<div class="todoTitle">${todo.title }</div>
								<div class="todoContent">
									<div class="todoBody">
										등록날짜: ${todo.registeredDate }, 
										${todo.name }, 
										우선순위 ${todo.sequence }
									</div>
									<button type="button" buttonStatus="TODO" buttonId=${todo.id}>-&gt;</button>
								</div>
							</div>
						</li>
					</c:if>
				</c:forEach>
			</ul>
		</div>
		
		<div class="list">
			<div class="status">DOING</div>
			<ul id="DOING">
				<c:forEach var="todo" items="${todoList }">		
					<c:if test="${todo.type == 'DOING'}">
						<li>
							<div class="todoCard">
								<div class="todoTitle">${todo.title }</div>
								<div class="todoContent">
									<div class="todoBody">
										등록날짜: ${todo.registeredDate }, 
										${todo.name }, 
										우선순위 ${todo.sequence }
									</div>
									<button type="button" buttonStatus="DOING" buttonId=${todo.id}>-&gt;</button>
								</div>
							</div>
						</li>
					</c:if>
				</c:forEach>
			</ul>
		</div>
		
		<div class="list">
			<div class="status">DONE</div>
			<ul id="DONE">
				<c:forEach var="todo" items="${todoList }">
					<c:if test="${todo.type == 'DONE'}">
						<li>
							<div class="todoCard">
								<div class="todoTitle">${todo.title }</div>
								<div class="todoContent">
									<div class="todoBody">
										등록날짜: ${todo.registeredDate }, 
										${todo.name }, 
										우선순위 ${todo.sequence }
									</div>
								</div>
							</div>
						</li>
					</c:if>
				</c:forEach>
			</ul>
		</div>
	</section>
	<script type="text/javascript" src="js/main.js"></script>
</body>
</html>