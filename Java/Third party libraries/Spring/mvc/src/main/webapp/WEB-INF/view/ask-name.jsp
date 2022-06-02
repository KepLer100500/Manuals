<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>Spring MVC</title>
</head>
<body>
    <h2>Enter yor name:</h2>
    <form action="show-name" method="GET">
        User name: <input type="text" name="userName" placeholder="Enter your name"><br><br>
        Nick name: <input type="text" name="nickName" placeholder="Enter your nick"><br>
        
        <button type="submit">Hello!</button>
        <button type="button" onclick="window.location.href='/'">Go main page</button>
    </form>
</body>
</html>
