<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>
	<c:out value="${requestScope['javax.servlet.error.message']}" /><br>
	<c:out value="${requestScope['javax.servlet.error.exception_type']}" /><br>
	<c:out value="${requestScope['javax.servlet.error.exception'] }" /><br>
	<c:out value="${requestScope['javax.servlet.error.status_code'] }" />
</body>
</html>