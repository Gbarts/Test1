<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${writers}" var="temp">
작성자: ${temp.writer} 글:${temp.cn} <br>
</c:forEach>
<button type="button" onclick='location.href="/board/list?pageNum=${criteria.pageNum}&amount=${criteria.amount}"'>목록보기</button>

</body>
</html>