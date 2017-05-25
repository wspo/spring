<%@ page language="java" import="db.connDb,db.Stu,java.util.*"  
    pageEncoding="gbk"%>   
    <%--jsp头文件，包括引入的包和支持语言，gbk为支持中文--%>  
<% 
new connDb();
ArrayList list = connDb.getList("select name,password from user"); //获得test表中所有数据并以列表形式返回  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
    <head>  
        <title>My JSP 'list.jsp' starting page</title>  
    </head>  
    <body>  
        <input type="button" name="bottom" value="添加新学生"  
            onclick="javascript:window.location.href='add.jsp'">  
        <br>  
        <br>  
        <table border="1">  
            <tr>  
                <td>  
                    name  
                </td>  
                <td>  
                    password  
                </td>   
            </tr>  
            <%  
                    {  
                    for (Iterator it = list.iterator(); it.hasNext();) {  
                        Stu s = (Stu) it.next();  
            %>  
            <tr>  
                <td><%=s.getName()%></td>  
                <td><%=s.getPassword()%></td>  
            </tr>  
            <%  
                }  
                }  
            %>  
        </table>  
    </body>  
</html> 