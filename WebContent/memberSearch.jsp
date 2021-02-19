<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조회</title>
</head>
<body>

<h3>회원정보 검색</h3>

${error }	<!-- ID미입력시 에러메세지 -->

<form action="memberSearch.do" method="post"> <!-- memberSErarch.do URL로 요청 -->
	ID : <input type="text" name="id"/>
	<input type="hidden" name="job" value="search"/>	<!-- 작업값 전달 검색,수정,삭제 중 -->
	<input type="submit" value="검색"/>
</form>
</body>
</html>