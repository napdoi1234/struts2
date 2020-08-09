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
	<h1 style="text-align: center;">Article List</h1>
	<button  class="btn btn-dark" style="border-radius:50%"><a href='/Struts2/article/insert.jsp' style="color:#bbc0c4" >Add</a></button>
	<p></p>
	<table class="table table-dark" style="background-color: #3b4045">
				
		<thead>
			<tr>
				<th>STT</th>
				<th>articleID</th>
				<th>articleName</th>
				<th>articleDate</th>
				<th>articleContent</th>
				<th>userID</th>
				<th>articleStatus</th>
				<th>Action</th>
				
			</tr>
		</thead>
		<%
			int index = 1;
		%>
		<tbody>
			<s:iterator var="article" value="articleList">
				<tr>
					<td><%=index++%></td>
					<td>${article.articleID}</td>
					<td>${article.articleName }</td>
					<td>${article.articleDate }</td>
					<td>${article.articleContent }</td>
					<td>${article.userID }</td>
					<td>${article.articleStatus }</td>
					<td><s:url var="edit" action="findu">
							<s:param name="article.articleID">${article.articleID}</s:param>
						</s:url> <s:a href="%{edit}" style="color:#bbc0c4">Edit</s:a>
						<s:url var="delete" action="deleteArticle">
							<s:param name="article.articleID">${article.articleID}</s:param>
						</s:url> <s:a href="%{delete}" style="color:#bbc0c4">Delete</s:a>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</body>
</html>