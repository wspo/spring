<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Spring MVC表单处理</title>
</head>
<body>

<h2>Student Information</h2>
<spring:form method="POST" action="/SpringMVC/addStudent">
   <table>
    <tr>
        <td><spring:label path="name">名字：</spring:label></td>
        <td><spring:input path="name" /></td>
    </tr>
    <tr>
        <td><spring:label path="age">年龄：</spring:label></td>
        <td><spring:input path="age" /></td>
    </tr>
    <tr>
        <td><spring:label path="id">编号：</spring:label></td>
        <td><spring:input path="id" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="提交表单"/>
        </td>
    </tr>
</table>  
</spring:form>
</body>
</html>