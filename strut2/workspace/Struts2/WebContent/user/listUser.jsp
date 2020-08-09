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
<body>
	<h1 style="text-align: center;">User List</h1>
	<button  class="btn btn-dark" style="border-radius:50%"><a href='/Struts2/user/insert.jsp' style="color:#bbc0c4" >Add</a></button>
	<p></p>
	<table class="table table-dark" style="background-color: #3b4045">
				
		<thead>
			<tr>
				<th>STT</th>
				<th>User ID</th>
				<th>Full Name</th>
				<th>Gender</th>
				<th>Phone</th>
				<th>Role</th>
				<th>Email</th>
				<th>User Status</th>
				<th>User Name</th>
				<th>Action</th>
			</tr>
		</thead>
		<%
			int index = 1;
		%>
		<tbody>
			<s:iterator var="user" value="userList">
				<tr>
					<td><%=index++%></td>
					<td>${user.user_ID}</td>
					<td>${user.full_Name }</td>
					<td>${user.gender }</td>
					<td>${user.phone }</td>
					<td>${user.role }</td>
					<td>${user.email }</td>
					<td>${user.user_Status }</td>
					<td>${user.username }</td>
					<td><s:url var="edit" action="findUser">
							<s:param name="user.user_ID">${user.user_ID}</s:param>
						</s:url> <s:a href="%{edit}" style="color:#bbc0c4">Edit</s:a>
						<s:url var="delete" action="deleteUser">
							<s:param name="user.user_ID">${user.user_ID}</s:param>
						</s:url> <s:a href="%{delete}" style="color:#bbc0c4">Delete</s:a>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</body>
</html>