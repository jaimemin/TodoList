<%@page import="com.nts.exception.CustomException"%>
<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>
	<h1>
		에러가 발생하였습니다.<br>
		잠시 후 다시 이용해주세요.
		<%
		String errorMessage = ((CustomException)exception).getErrorMessage();
		out.println(errorMessage);
	%>
	</h1>
</body>
</html>