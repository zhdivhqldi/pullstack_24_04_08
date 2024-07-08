<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="frontproject1.vo.SampleTBVO" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%
	SampleTBVO sview = (SampleTBVO)request.getAttribute("sview");
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>sampleTB 상세페이지!</h2>
	<table>
		<tbody>
			<tr>
				<th align="right">글번호:</th>
				<%-- <td><%=sview.getSno() %></td> --%>
				<td>${sview.sno}</td>
			</tr>
			<tr>
				<th align="right">제목:</th>
				<%-- <td><%=sview.getTitle() %></td> --%>
				<td>${sview.title}</td>
			</tr>
			<tr>
				<th align="right">작성자:</th>
				<%-- <td><%=sview.getWriter() %></td> --%>
				<td>${sview.writer}</td>
			</tr>
			<tr>
				<th align="right">작성일:</th>
				<%-- <td><%=sview.getRdate() %></td> --%>
				<td>${sview.rdate}</td>
			</tr>
			<tr>
				<th align="right">내용:</th>
				<%-- <td><%=sview.getBody() %></td> --%>
				<td>${sview.body}</td>
			</tr>
		</tbody>
	</table>
	<button 
		onclick
		=
		"location.href='modify.do?sno=${sview.sno}'">
		수정
	</button> 
	<!-- 서블릿을 사용하여 수정페이지 만드세요.제목,작성자,내용 변경가능 -->
</body>
</html>


