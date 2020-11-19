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
	<form action="search.do" method="GET" class="navbar-form navbar-right" role="search">
        <div class="form-group">
          <input type="text" class="form-control" name="search" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
	<c:choose>
		<c:when test="${result != 0}">
 		<table class="table table-hover">
	 		<thead>
	 			<tr>
	 				<th>번호</th>
	 				<th>제목</th>
	 				<th>작성자</th>
	 				<th>작성일</th>
	 			</tr>
	 		</thead>
	 		<tbody>
	 		<c:forEach items="${bList}" var="b">
	 			<tr>
	 				<td>${b.board_num}</td>
	 				<td><a href="view.do?board_id=${b.board_id}">${b.board_title}</a></td>
	 				<td>${b.user_id}</td>
	 				<td>${b.board_date}</td>
 					</tr>
				</c:forEach>
 			</tbody>
		</table>
		<div class="text-right">
			<a href="write.do"><button>글작성</button></a>
		</div>
		<nav>
		<div class="text-center">
	 	 <ul class="pagination">
    	<c:if test="${page_button >= 1}">
		   	  <li>
		      	<a href="<c:url value="list.do"><c:param name="page_number" value="${page_number - 1}"></c:param></c:url>">
		        	<span aria-hidden="true">&laquo;</span>
		      	</a>
		      </li>
    		<c:forEach begin="1" end="${page_button}" step="1" var="page">
    			<li><a href="<c:url value="list.do"><c:param name="page_number" value="${page}"></c:param></c:url>">${page}</a></li>
    		</c:forEach>
		      <li><a href="<c:url value="list.do"><c:param name="page_number" value="${page_number + 1}"></c:param></c:url>">
		        <span aria-hidden="true">&raquo;</span>
		      	</a>
    		  </li>
    	</c:if>
	 		 	</ul>
			  </div>
			</nav>		
		</c:when>
		<c:otherwise>
			<table class="table table-hover">
	 		<thead>
	 			<tr>
	 				<th style="text-align: center; font-size: 24px;">작성된 게시물이 없습니다.</th>
	 			</tr>
	 		</thead>
	 		</table>
			<div class="text-right">
				<a href="write.do"><button>글작성</button></a>
			</div>
		</c:otherwise>
	</c:choose>
	</form>
</body>
</html>