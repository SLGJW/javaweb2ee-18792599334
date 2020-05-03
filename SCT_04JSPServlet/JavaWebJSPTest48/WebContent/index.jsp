<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>录入学生信息页面</title>
</head>
<body bgcolor="orange">    
<form action="success.jsp" method="post">
   <h1><b>学生信息录入</b></h1>
    学号 <input name="studynum" type="text"><br>    
    姓名<input name="name" type="text"><br>
    生日<input name="birthday" type="date" "><br>
    性别<input type="radio" value="男" checked="checked" name="sex" />男
    <input type="radio" value="女" name="sex"/>女   <br> 
您所了解的编程语言:<br>
    <input type="checkbox" name="hobby" value="Java">java<br>
    <input type="checkbox" name="hobby" value="C#">C#<br>
    <input type="checkbox" name="hobby" value="python">python<br>
   <input type = "checkbox" name="hobby" value="C语言">C语言 <br>  
    <input type="submit" value="提交" >
    <input type="reset" value="重置">
</form>
</body>
</html>