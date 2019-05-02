<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2>c:choose标签</h2>
	<c:choose>
		<c:when test="${age<18 }">
			少年
		</c:when>
		<c:when test="${age>=18 && age<35 }">
			青年
		</c:when>
		<c:when test="${age>=35 && age<50 }">
			壮年
		</c:when>
		<c:otherwise>
			老年
		</c:otherwise>
	</c:choose>
</body>
</html>