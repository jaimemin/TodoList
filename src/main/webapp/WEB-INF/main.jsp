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
			<a href="./todoform">새로운 TODO 등록</a>
		</div>
	</header>
	<section class="listSection">
		<div class="status">TODO</div>
		<ul>
			<c:forEach var="todo" items="${todoList }">
				<c:if test="${todo.type == 'TODO' }">
					<li>
						<div class="todoCard" id="TODO">
							<div class="todoTitle">${todo.title }</div>
							<div class="todoContent">
								<div class="todoBody">
									등록날짜: ${todo.registeredDate }, 
									${todo.name }, 
									우선순위 ${todo.sequence }
								</div>
								<button>-&gt;</button>
							</div>
						</div>
					</li>
				</c:if>
			</c:forEach>
		</ul>
		
		<div class="status">DOING</div>
		<ul>
			<c:forEach var="todo" items="${todoList }">		
				<c:if test="${todo.type == 'DOING'}">
					<li>
						<div class="todoCard" id="DOING">
							<div class="todoTitle">${todo.title }</div>
							<div class="todoContent">
								<div class="todoBody">
									등록날짜: ${todo.registeredDate }, 
									${todo.name }, 
									우선순위 ${todo.sequence }
								</div>
								<button>-&gt;</button>
							</div>
						</div>
					</li>
				</c:if>
			</c:forEach>
		</ul>
		
		<div class="status">DONE</div>
		<ul>
			<c:forEach var="todo" items="${todoList }">
				<c:if test="${todo.type == 'DONE'}">
					<li>
						<div class="todoCard" id="DONE">
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
	</section>
</body>
</html>