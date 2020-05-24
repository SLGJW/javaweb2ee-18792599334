<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加学生</title>
</head>
<body bgcolor="orange">

	<form action= "student/add" method= "get">
	   学&nbsp;&nbsp;号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  type="text" name="Sid" /><br />
        姓&nbsp;&nbsp;名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  type="text" name="Sname" /><br />
        出生日期：<input class="inp2" type="text" name="Sbirthday"/><br />
        性别：男：<input type="radio" name="Ssex" value="男" />
        女：<input type="radio" name="Ssex" value="女" /><br />
        <input type="reset" value="重置" />
        <input type="submit" value="提交" />
    </form>
	
	
	
	
	</form>

</body>
</html>