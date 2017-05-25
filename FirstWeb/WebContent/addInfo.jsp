<%@ page language="java" import="db.connDb" pageEncoding="gbk"%>  
<%  
 String name=new String(request.getParameter("name"));   
 String password = new String(request.getParameter("password")); 
 connDb.add("insert into user (name,password) values ('"+name+"','"+password+"')");  
 response.sendRedirect("list.jsp");  
%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
    <head>  
        <title>My JSP 'addinfo.jsp' starting page</title>  
    </head>  
    <body>  
        Ìí¼Ó³É¹¦£¡  
        <br>  
    </body>  
</html>