<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 회원가입2</title>
</head>
<body>
	<h2>학생 회원가입2</h2>
	<hr>
	<form action="joinOk2">
		아이디 : <input type="text" name="id"><br><br>
		비밀번호 : <input type="password" name="pw"><br><br>
		이 름 : <input type="text" name="name"><br><br>
		나 이 : <input type="text" name="age"><br><br>
		<input type="submit" value="회원가입">
	</form>
	<hr>
	<c:if test="${not empty error}">
		<span style="color: red;">${error} 잘못 입력하셨습니다. 다시 입력해주세요.</span>
	</c:if>
</body>
</html>