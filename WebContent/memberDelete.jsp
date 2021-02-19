<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제</title>
</head>
<body>
<h3>삭제 정보 검색</h3>
${error }
<form action="memberSearch.do" method="post">
	ID : <input type="text" name="id"/>
	<input type="hidden" name="job" value="delete"/>
	<input type="submit" value="검색">
	
</form>

<% MemberVO member = (MemberVO)request.getAttribute("member");
	if(member != null){
%>
<h3>검색 정보 결과</h3>
${member.id } / ${member.passwd } / ${member.name } / ${member.mail }<p>

<form action="memberDelete.do" method="post">		<!-- 삭제 작업을 위한 form 회원id 담아서 전달 -->
	<input type="hidden" name ="id" value="${member.id }"/>
	<input type="submit" value="삭제"/>
	
</form>
<%} else{ %>
${result }><p>
<%} %>
</body>
</html>