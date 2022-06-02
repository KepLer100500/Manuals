<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Spring MVC</title>
</head>
<body>
    <h2>Hello ${user}!</h2>
    User: ${user.name}<br>
    Pass: ${user.pass}<br>
    Age: ${user.age}<br>
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
    <br>
    <a href="/"><button>Go main page</button></a>
</body>
</html>
