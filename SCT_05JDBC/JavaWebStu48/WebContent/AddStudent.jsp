<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息录入</title>
</head>
<body>
<h1>学生信息录入</h1>
    <form action="add-student" method="post">
    学号：<input type="text" name="sid"> <br>
        姓名：<input type="text" name="sname"><br>
        生日：<input type="date" name="sbirthday"><br>
        性别：<input type="radio" name="ssex" value="男">男
        <input type="radio" name="ssex" value="女">女<br>
        <input type="reset" value="重置">
        <input type="submit" value="提交">
    </form>

</body>
</html>