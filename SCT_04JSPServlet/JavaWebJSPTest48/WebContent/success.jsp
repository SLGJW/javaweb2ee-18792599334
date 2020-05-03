<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息显示</title>
</head>
<body bgcolor="orange">
 <h1><b>学生信息如下所示</b></h1>
 <% request.setCharacterEncoding("UTF-8");
 	String studynum = request.getParameter("studynum");
    String name = request.getParameter("name");
    String birthday = request.getParameter("birthday");
    String sex = request.getParameter("sex");
    String [] hobbys= request.getParameterValues("hobby");    
 %>
  <h2><b>
        学号:<%=studynum%><br>
        姓名:<%=name%><br>
        生日:<%=birthday%><br>
        性别:<%=sex%><br>
      爱好:<%for(String h:hobbys){
         out.println("&nbsp"+h);
     } %>
     </b>
    </h2>
</body>
</html>