<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	News Pages RSS Feed List
</h1>

<P>  The time on the server is ${serverTime}. </P>

<table>
<tr>
    <td>

<c:if test="${!empty rssFeedList}">

        <table>
        <tr>
            <td>
                <form name="addForm" action="newfeed" method="post">
               	    <input type="submit" value="Add Feed" />
               	</form>
            </td>
        </tr>
        </table>

    </td>
</tr>

<tr>
    <td>
        <table class="tg">

        <c:forEach var="i" begin="0" end ="${fn:length(rssFeedList)-1}">

        <form name="selectForm${i}" action="feed/${i}" method="post">
            <tr>
                 <th width="20">Title: </th>
                 <td width="80"><input type="submit" value="${rssFeedList[i].name}"></td>
                 <th width="20">URL: </th>
                 <td>${rssFeedList[i].url}</td>

            </tr>
        </form>

        </c:forEach>

        </table>
    </td>
</tr>
</table>
</c:if>

</body>
</html>