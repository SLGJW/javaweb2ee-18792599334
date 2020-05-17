<%@page import="com.sxlg.project.servlet.Information"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deal</title>
</head>
<body>
<a href="/JavaWebStu48/AddStudent.jsp">添加学生</a>
<% request.setCharacterEncoding("utf-8");%>
<% Information inf = (Information)request.getAttribute("inf"); %>
学号<%=inf.getSid() %>
姓名<%=inf.getSname() %>
生日<%=inf.getSbirthday() %>
性别<%=inf.getSsex() %>
</body>
</html>