<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录成功</title>
</head>
<% String name=(String)session.getAttribute("user");
        if(name!=null){%>
            <body>
                <h1><%=request.getSession().getAttribute("user")%>欢迎您!</h1>
                <h3>点击此处<a href="/JavaWebSession48/logout-servlet">【注销】</a></h3>
            </body>
        <%}else{ %>
            <%request.setAttribute("unlogin", "请先登录");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
             %>
        <%} %>
</html>