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
	<form action="write.do" method="POST">
		<input type="text" class="form-control" placeholder="제목" name="board_title">
		<textarea class="form-control" rows="3" placeholder="내용" name="board_content"></textarea>
		<div class="text-right">
			<button type="submit" value="글작성">글작성</button>
			<button type="reset" value="다시 작성">다시 작성</button>
		</div>
	</form>
</body>
</html>