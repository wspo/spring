<%@ page language="java" import="db.connDb,db.Stu,java.util.*"  
    pageEncoding="gbk"%>   
    <%--jspͷ�ļ�����������İ���֧�����ԣ�gbkΪ֧������--%>  
<% 
new connDb();
ArrayList list = connDb.getList("select name,password from user"); //���test�����������ݲ����б���ʽ����  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
    <head>  
        <title>My JSP 'list.jsp' starting page</title>  
    </head>  
    <body>  
        <input type="button" name="bottom" value="�����ѧ��"  
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