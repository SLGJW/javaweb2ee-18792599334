<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body bgcolor="orange">
<form action="login-servlet" method="post">
     <h1>用户登陆系统</h1>
      用户名：<input type="text" name="username"><br>
      密码：&nbsp;&nbsp;&nbsp;
      <input type="password" name="password"><br>
      <input type="reset" value="重置">
      <input type="submit" value="登录">
    </form>

    <div><%=request.getAttribute("loginlose")==null?"":request.getAttribute("loginlose")%></div>
    <div><%=request.getAttribute("logoutsuccess")==null?"":request.getAttribute("logoutsuccess")%></div>
    <div><%=request.getAttribute("unlogin")==null?"":request.getAttribute("unlogin")%></div>

</body>
</html>