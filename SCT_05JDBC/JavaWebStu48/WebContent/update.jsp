<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改数据</title>
</head>
<body>
<h1>学生信息修改</h1>
    <form action="update-servlet" method="post">
        学号：<input type="text" name="sid"> <br>
        姓名：<input type="text" name="sname"><br>
        <input type="reset" value="重置">
        <input type="submit" value="提交">
    </form>
</body>
</html>