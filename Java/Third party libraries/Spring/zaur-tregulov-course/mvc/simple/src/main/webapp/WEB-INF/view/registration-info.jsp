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
    <h2>Hello ${user.name}!</h2>
    User: ${user.name}<br>
    Pass: ${user.pass}<br>
    Age: ${user.age}<br>
    Phone: ${user.phone}<br>
    Email: ${user.email}<br>
    Department: ${user.department}<br>
    Sub Department: ${user.subDepartment}<br>
    Sex: ${user.sex}<br>
    Roles: 
    <ul>
        <c:forEach var="role" items="${user.roles}">
            <li>
                ${role}
            </li>
        </c:forEach>
    </ul>
    <button type="button" onclick="window.location.href='/'">Go main page</button>
</body>
</html>
