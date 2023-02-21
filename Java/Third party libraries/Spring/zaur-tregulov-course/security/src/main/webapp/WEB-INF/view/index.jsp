<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h2>Main page</h2>
    <br>
    <security:authorize access="hasRole('ADMINISTRATOR')">
    <input type="button" value="Go admin panel" onClick="window.location.href='admin'"/>
    </security:authorize>
    <br><br>
    <security:authorize access="hasAnyRole('ADMINISTRATOR', 'MODERATOR')">
    <input type="button" value="Go moderator page" onClick="window.location.href='moderator'"/>
    </security:authorize>
</body>
</html>