<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<form action="update.do" method="POST">
	<input type="text" class="form-control"  name="board_title" value="${bDto.board_title}" required>
	<textarea class="form-control" rows="3"  name="board_content" required>${bDto.board_content}</textarea>
	<button type="submit" value="글작성">글작성</button>
	<div style="display: none;">
		<input type="text" name="board_id" value="${bDto.board_id}" />
	</div>
</form>
	<a href="list.do"><button>글 목록</button></a>
</body>
</html>