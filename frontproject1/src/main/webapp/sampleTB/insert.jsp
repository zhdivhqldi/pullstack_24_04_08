<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = request.getParameter("msg");
	if(msg  != null && msg.equals("fail")){
		%>
		<script>
			alert("등록 실패!");
		</script>
		<%
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>sampleTB 등록페이지!</h2>
<form action="insert.do" method="post">
	<table>
		<tbody>
			<tr>
				<th align="right">제목:</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th align="right">작성자:</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th align="right">내용:</th>
				<td><textarea name="body"></textarea></td>
			</tr>
		</tbody>
	</table>
	<button>저장</button>
</form>
</body>
</html>