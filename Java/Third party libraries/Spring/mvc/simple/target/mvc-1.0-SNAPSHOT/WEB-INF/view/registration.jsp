<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Spring MVC</title>
</head>
<body>
    <br><br><br>
    <form:form action="registration-info" modelAttribute="user">
        User: <form:input path="name"/>
        <form:errors path="name"/>
        <br><br>
        Pass: <form:input path="pass"/>
        <form:errors path="pass"/><br><br>
        Age: <form:input path="age"/><br><br>
        Department: <form:select path="department">
            <form:option value="HR 100" label="HR" />
            <form:option value="IT 404" label="IT" />
            <form:option value="Sales 500" label="Sales" />
        </form:select><br><br>
        Sub Department: <form:select path="subDepartment">
            <form:options items="${user.subDepartments}"/>
        </form:select><br><br>
        Sex: <form:radiobuttons path="sex" items="${user.sexs}" element="li"/>
        <br><br>
        Roles: <form:checkboxes path="roles" items="${user.rolesMap}" element="li"/>
        <br><br>
        <input type="submit" value="Register me!">
    </form:form>
    <br><br>
    <a href="/"><button>Go main page</button></a>
</body>
</html>
