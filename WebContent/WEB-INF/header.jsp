<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Suvery</title>
</head>
<style>
*{padding: 6px;}	
.head{text-align: center; color: black; font-size: 47px;}
a:hover{text-decoration: none;}
body{margin-left: 5%; margin-right: 5%;}
.user_link{text-align: right;}
</style>
<body>
	<p class="head" style="padding: 20px;">Check Money</p>
    <nav class="navbar navbar-inverse">
        <ul class="nav navbar-nav navbar-left">
            <li role="presentation" class="active"><a href="main.do">Home</a></li>
            <li role="presentation"><a href="list.do">설문조사 게시판</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
        	<c:if test="${sessionID != null}">
				<li role="presentation"><a href=".">${sessionID}</a></li>
	        	<li role="presentation"><a href="logout.do">로그아웃</a></li>
        	</c:if>
        	<c:if test="${sessionID == null}">
            <li role="presentation"><a href="login.do">로그인</a></li>
            <li role="presentation"><a href="join.do">회원가입</a></li>
            </c:if>
        </ul>
      </nav>
</body>
</html>