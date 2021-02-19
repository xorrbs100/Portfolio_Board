<%@page import="vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>

<%-- <% ArrayList<MemberVO> list= (ArrayList<MemberVO>)request.getAttribute("list");		//회원정보가 담긴 ArrayList 객체 추출
//list = (ArrayList<MemberVO>)request.getAttribute("list");
/* ArrayList가 비었는지 확인 */
	if(!list.isEmpty()){ %>	
<table border="1">
	<tr><th>ID</th><th>비밀번호</th><th>이름</th><th>이메일</th></tr>
	
	<% for(int i=0; i<list.size(); i++){		//등록된 회원수만큼 반복
		MemberVO member = list.get(i); %>	<!-- i번째 객체추출 -->
		
		<!-- getter 메소드로 출력 -->
		<tr><td><%=member.getId() %></td>
			<td><%=member.getPasswd() %></td>
			<td><%=member.getName() %></td>
			<td><%=member.getMail() %></td>
			</tr>
	<% } 
	}else{
		out.print("<h3>등록된 회원정보가 없습니다.</h3>");	//ArrayList가 비었을때 = member 테이블이 비었을 때
	}
	
	%> 
	
	
</table> --%>
 <% out.print(request.getAttribute("list")); %> 
<%@ include file="adminHome.jsp" %>
</body>
</html>