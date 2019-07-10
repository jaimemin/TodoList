<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	/*
		WEB-INF 내에 index.jsp를 넣을 경우 리다이렉트 실패
		이를 web.xml에 코드를 추가하여 해결했지만 이유가 궁금합니다.
	*/
	response.sendRedirect("/TodoList/main");
%>
