<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loading File System Properties</title>
    </head>
    <body>
        <h3>Loading File System Properties</h3>
		<h4>Using the Class Loader</h4>
		<form action="results.do" >
			Absolute File Name: <input type="text" name="filename" value="/configuration.properties"/><br />
			<input type="submit" value="Submit" />
		</form>
		<h4>Using the URL</h4>
    </body>
</html>
