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
    <h2>Hello, ${updatedName}</h2>
    <h3>Hi, ${nickName}</h3>
    <button type="button" onclick="window.location.href='/'">Go main page</button>
</body>
</html>
