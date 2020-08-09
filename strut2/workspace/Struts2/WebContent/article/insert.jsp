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
<body class="jumbotron">
	<s:form action="inserta" method="post"
		style="position:absolute ;top:25%;left:40%" >
		<s:textfield name="article.articleID" label="Article ID"></s:textfield>

		<s:textfield name="article.articleName" label="articleName"></s:textfield>
		<s:textfield name="article.articleDate" label="articleDate"></s:textfield>

		<s:textfield name="article.articleContent" label="articleContent"></s:textfield>

		<s:textfield name="article.userID" label="userID"></s:textfield>

		<s:textfield name="article.articleStatus" label="articleStatus"></s:textfield>

		<s:submit value="add Article" style="float:right"></s:submit>
	</s:form>

</body>
</html>