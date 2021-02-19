<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색결과</title>
</head>
<body>
	
	<H3>검색결과</H3>
	
	<%
		String result = (String)request.getAttribute("result");	//result 이름으로 등록된 정보 추출 member 테이블에서 추출된 회원정보가 없을 때 등록되는 정보 (검색된 id가 없습니다)
		
		if(result!=null){	//result 값이 있을때
			out.print(result+"<p>");
		}else{	//member 에서 추출된 정보가 있을때
	
	%>
	<h3>ID : ${member.id} / 비밀번호 : ${member.passwd } / 이름 : ${member.name } / 메일 : ${member.mail }</h3>		<!-- member객체 반환값 출력 -->
	<%} %>
	<%@ include file="adminHome.jsp" %>
</body>
</html>