<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
<h3>수정 정보 검색</h3>
${error }	<!-- 에러메시지 -->

<form action="memberSearch.do" method="post">		<!-- 수정할 회원정보 id로 검색 -->
	ID : <input type="text" name="id"/>
	<input type="hidden" name="job" value="update">
	<input type="submit" value="검색"> 	
</form>

	<% MemberVO member = (MemberVO)request.getAttribute("member");		// 검색 후 회원정보가 MEmberVO객체에 담겨 member이름으로 등록되어 전달 member를 추출하여 지역변수로 저장
		if(member != null){ %>		<!-- member변수가 null이 아니면 회원정보가 존재 -->
			<h3>회원정보 수정</h3>
			<form action="memberUpdate.do" method="post">
			<!-- 초기값 설정 -->
				ID : <input type="text" name="id" readonly="readonly" value="${member.id }"><br>		<!-- primarykey id는 읽기전용 수정불가 -->
				비밀번호 : <input type="password" name="passwd" value="${member.passwd }"><br>
				이름 : <input type="text" name="name" value="${member.name }"><br>
				E-mail : <input type="text" name="mail" value="${member.mail }">
				<input type="submit" value="수정">
			</form>
		<% }else{ %>
			${result }<p>	<!-- member가 null 일때 result값 반환 -->
		<%} %>
</body>
</html>