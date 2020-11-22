<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Suvery</title>
</head>
<style>
#login .container #login-row #login-column #login-box {
  margin-top: 70px;
  max-width: 600px;
  height: 380px;
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
                            <h3 class="text-center text-info">로그인</h3>
                            <div class="form-group">
                                <label for="username" class="text-info">아이디:</label><br>
                                <input type="text" name="user_id" id="username" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">비밀번호:</label><br>
                                <input type="password" name="user_pw" id="password" class="form-control">
                            </div>
                            <div class="form-group navbar-right">
                            	<input type="submit" name="submit" class="btn btn-info btn-md" value="로그인">
                            </div>
                            <div id="register-link" class="text-right navbar-left">
                                <a href="join.do" class="text-info">회원가입</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>