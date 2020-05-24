<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员登录</title>
<style type="text/css">
#ts{
    color:red;
}
</style>
</head>
<body bgcolor="deepskyblue">
<h1>管理员登录</h1>
    <form action="login-servlet" method="post">
      <label>登录名：</label>
      <input type="text" name="username"><br />
      <label> 密码：</label>&nbsp&nbsp&nbsp&nbsp
      <input type="password" name="password"><br />
      <input type="reset" value="重置">
      <input type="submit" value="登录">
    </form>
    <div id="ts"><%=request.getAttribute("loginlose")==null?"":request.getAttribute("loginlose")%>
        <%=request.getAttribute("logoutsuccess")==null?"":request.getAttribute("logoutsuccess")%>
        <%=request.getAttribute("unlogin")==null?"":request.getAttribute("unlogin")%></div>

</body>
</html>