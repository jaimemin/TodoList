<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	/*
		WEB-INF 내에 index.jsp를 넣을 경우 리다이렉트 실패
		.을 추가하지 않을 경우에도 마찬가지로 리다이렉트 실패하여 404 에러가 발생
	*/
	response.sendRedirect("./main");
%>
