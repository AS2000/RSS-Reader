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
	News page RSS feed details
</h1>

<table>
<tr>
    <td>

        <table class="table-links">
        <tr>
            <th width="60">Feed Name: </th>
            <td>${rssFeed.name}</td>
            <td colspan="2">
                <form name="backForm" action="feedlist" method="post">
               	    <input type="submit" value="Back to List" />
               	</form>
            </td>
        </tr>
        <tr>
            <th>Feed URL: </th>
            <td>${rssFeed.url}</td>
            <td></td>
        </tr>
        <tr>
            <th>Update Time: </th>
            <td>${updateTime}</td>
            <td colspan="2">
                <form name="removeForm" action="remove/${id}" method="post">
               	    <input type="submit" value="Remove Feed" />
               	</form>
            </td>
        </tr>
        </table>

    </td>
</tr>

<tr>
    <td>
        <table class="tg">

        <c:forEach items="${rssFeed.articles}" var="article">
            <tr>
                 <th width="20">Title: </th>
                 <td width="200">${article.title}</td>
            </tr>
            <tr>
                 <th>URL: </th>
                 <td><a href="${article.url}">${article.url}</a></td>

            </tr>
        </c:forEach>

        </table>
    </td>
</tr>
</table>

</body>
</html>