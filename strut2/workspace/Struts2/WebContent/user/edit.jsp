<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
    <%@include file="/bootstrap/css/bootstrap.min.css" %>
</style>
</head>
<body  class="jumbotron">
	<s:form action="updateu" method="post" style="position:absolute ;top:25%;left:40%">
		<s:hidden name="user.user_ID" label="User ID"></s:hidden>
		
		<s:textfield name="user.full_Name" label="Full_Name"></s:textfield>
		
		<s:textfield name="user.gender" label="Gender"></s:textfield>
		
		<s:textfield name="user.phone" label="Phone"></s:textfield>
		
		<s:textfield name="user.role" label="Role"></s:textfield>
	
		<s:textfield name="user.email" label="Email"></s:textfield>
	
		<s:textfield name="user.user_Status" label="User_Status"></s:textfield>
	
		<s:textfield name="user.username" label="Username"></s:textfield>
		
		<s:submit value="update User" style="float:right"></s:submit>
	</s:form>

</body>
</html>