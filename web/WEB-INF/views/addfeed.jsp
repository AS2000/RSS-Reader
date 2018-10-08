<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>RSS Feeder</title>
		<style type="text/css">
            #border { border-radius: 15px; border: 1px solid  #808080; padding: 20px; width: 460px; height: 180px; }
            #tablepad { padding-top: 10px; padding-bottom: 20px;}
            .linespad tr{ height: 30px;}

            #big {font-family:Arial, sans-serif; font-size:22px; font-weight: bold;}
            #small {font-family:Arial, sans-serif; font-size:16px; font-style:italic; font-weight: bold;}
            #title {font-family:Arial, sans-serif; font-size:16px; font-weight: bold;}

            #button { border-radius: 5px; border: 1px solid  #808080; width: 200px;  height: 32px; font-family:Arial, sans-serif; font-size:16px; text-align: center; background-image: linear-gradient(#FCFCFC,#CDCDCD ); font-weight: bold;cursor: pointer;}
		</style>
</head>
<body>
<table id="border">

<tr><td><p id="big">Add XML RSS Feed</p></td></tr>

<tr><td><p id="small">Please provide new XML RSS Feed Information </p></td></tr>

<tr>
    <td>
<form:form action="addfeed" modelAttribute="feed" method="POST">

        <table id="tablepad" class="linespad">
        <tr>
		    <td width="20">
			    <form:label path="url">
				    <p id="title">XML RSS Feed URL:</p>
    			</form:label>
	    	</td>
		    <td>
			<form:input path="url" size="26" />
		    </td>
        </tr>
        <tr>
		    <td>
			    <form:label path="name">
				    <p id="title">XML RSS Feed Name:</p>
			    </form:label>
		    </td>
		    <td>
			    <form:input path="name" size="26" />
		    </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" id="button" value="Add Feed" />
            </td>
        </tr>
        </table>

</form:form>
    </td>
</tr>
</table>

</body>
</html>