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
<c:forEach items="${dist}" var="temp">
중복된글: ${temp.du} 
</c:forEach> <br>
<button type="button" onclick='location.href="/board/list?pageNum=${criteria.pageNum}&amount=${criteria.amount}"'>목록보기</button>
</body>
</html>