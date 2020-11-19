<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
#login .container #login-row #login-column #login-box {
  margin-top: 50px;
  max-width: 600px;
  height: 540px;
  border: 1px solid #9C9C9C;
  background-color: #EAEAEA;
  margin-left:53%; 
}
#login .container #login-row #login-column #login-box #login-form {
  padding: 20px;
}
#login .container #login-row #login-column #login-box #login-form #register-link {
  margin-top: -20px;
}
</style>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
     <div id="login">
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="login.do" method="POST">
                            <h3 class="text-center text-info">회원가입</h3>
                            <div class="form-group">
                                <label for="username" class="text-info">아이디:</label><br>
                                <input type="text" name="user_id" id="user_id" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">비밀번호:</label><br>
                                <input type="text" name="user_pw" id="user_pw" class="form-control">
                            </div>
                          	<div class="form-group">
                                <label for="name" class="text-info">이름:</label><br>
                                <input type="text" name="user_name" id="user_name" class="form-control">
                            </div>
                            <div class="form-group">
                            	<label for="gender" class="text-info">성별</label><br>
                              	<select name="user_gender">
								    <option value="">성별</option>
									<option value="남성">남성</option>
									<option value="여성">여성</option>
								</select>
							</div>
                            <div class="form-group navbar-right">
                            	<input type="submit" name="submit" class="btn btn-info btn-md" value="회원가입">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>