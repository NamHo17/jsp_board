<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
	<p>제목</p> 
	<label>${bDto.board_title}</label> <br/><br/>
	<p>내용</p> 
	<label>${bDto.board_content}</label> <br/><br/>
	<p>날짜</p>
	<label>${bDto.board_date}</label> <br/><br/>
	<p>작성자</p>
	<label>${bDto.user_id}</label>  <br/><br/>
	<c:if test="${sessionID == bDto.user_id || sessionID == null}">
	<a href="update.do?board_id=${bDto.board_id}"><button>글 수정</button></a>
	<a href="delete.do?board_id=${bDto.board_id}"><button>글 삭제</button></a>
	</c:if>
	<a href="list.do"><button>글 목록</button></a>
</body>
</html>