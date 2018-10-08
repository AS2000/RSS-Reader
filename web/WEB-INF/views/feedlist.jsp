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

	            #big {font-family:Arial, sans-serif; font-size:22px; font-weight: bold;}
                #small {font-family:Arial, sans-serif; font-size:16px; font-style:italic; font-weight: bold;}
		</style>
</head>
<body>

<table>
<tr><td><p id="big">XML RSS Feed</p></td></tr>

<tr><td><p id="small">Please find the list of all available feeds</p></td></tr>

<tr>
    <td>
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
    <c:if test="${!empty rssFeedList}">

        <table class="tg">

        <c:forEach var="i" begin="0" end ="${fn:length(rssFeedList)-1}">

        <form name="selectForm${i}" action="feed/${i}" method="post">
            <tr>
                 <th width="20px">Title: </th>
                 <td width="80px" align="center"><input type="submit" value="${rssFeedList[i].name}"></td>
                 <th width="20px">Article&nbsp;Qty.: </th>
                 <td width="20px" align="center">${fn:length(rssFeedList[i].articles)}</td>
                 <th width="20px">URL: </th>
                 <td>${rssFeedList[i].url}</td>
            </tr>
        </form>

        </c:forEach>

        </table>
    </c:if>
    </td>
</tr>

</table>

</body>
</html>