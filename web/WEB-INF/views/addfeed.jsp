<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>RSS Feeder</title>
		<style type="text/css">
				.tg {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}

        		.table-links th{text-align: left;}
        		.tg .table-links {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
                .table-links td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        		.table-links th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}

        		.tg .table-links .tg-4eph{background-color:#f9f9f9}
		</style>
</head>
<body>
<h1>
	Add XML RSS Feed
</h1>

<P>  Please provide new XML RSS Feed Information </P>

<c:url var="addAction" value="/addfeed" ></c:url>
<form:form action="${addAction}" commandName="feed">

<table>
<tr>
		<td>
			<form:label path="url">
				<spring:message text="XML RSS Feed URL:"/>
			</form:label>
		</td>
		<td>
			<form:input path="url" />
		</td>
</tr>
<tr>
		<td>
			<form:label path="name">
				<spring:message text="XML RSS Feed Name:"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td>
</tr>

	<tr>
		<td colspan="2">
			<c:if test="${!empty person.name}">
				<input type="submit" value="<spring:message text="Add Feed"/>" />
			</c:if>
		</td>
	</tr>




</table>
</c:if>

</body>
</html>