<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>생성</title>
</head>
<body>

<h3> 회원가입 </h3>

${error }		<!-- 오류메시지 출력코드 -->

<!-- 가입 버튼후 처리할 프로그램 memberInsert.do 지정 -->
<form action="memberInsert.do" method="post">
 Id : <input type="text" name="id"><br>
 비밀번호 : <input type="password" name="passwd"><br>
 이름 : <input type="text" name="name"><br>
 E-mail : <input type="text" name="mail"><br>
 <input type="submit" value="가입">
</form>
</body>
</html>