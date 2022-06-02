<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <h2>Registration form</h2>
    <form:form action="registration-info" modelAttribute="user">
        <table>
            <tr>
                <td>
                    User:
                </td>
                <td>
                    <form:input path="name"/>
                </td>
                <td>
                    <form:errors path="name" class="error-message"/>
                </td>
            </tr>
            <tr>
                <td>
                    Pass:
                </td>
                <td>
                    <form:input path="pass"/>
                </td>
                <td>
                    <form:errors path="pass" class="error-message"/>
                </td>
            </tr>
            <tr>
                <td>
                    Age:
                </td>
                <td>
                    <form:input path="age"/>
                </td>
                <td>
                        <form:errors path="age" class="error-message"/>
                </td>
            </tr>
            <tr>
                <td>
                    Phone:
                </td>
                <td>
                    <form:input path="phone"/>
                </td>
                <td>
                    <form:errors path="phone" class="error-message"/>
                </td>
            </tr>
            <tr>
                <td>
                    Email:
                </td>
                <td>
                    <form:input path="email"/>
                </td>
                <td>
                    <form:errors path="email" class="error-message"/>
                </td>
            </tr>
            <tr>
                <td>
                    Department:
                </td>
                <td>
                    <form:select path="department">
                        <form:option value="HR 100" label="HR" />
                        <form:option value="IT 404" label="IT" />
                        <form:option value="Sales 500" label="Sales" />
                    </form:select>
                </td>
                <td>
                    
                </td>
            </tr>
            <tr>
                <td>
                    Sub Department:
                </td>
                <td>
                    <form:select path="subDepartment">
                        <form:options items="${user.subDepartments}"/>
                    </form:select>
                </td>
                <td>
                    
                </td>
            </tr>
            <tr>
                <td>
                    Sex:
                </td>
                <td>
                    <form:radiobuttons path="sex" items="${user.sexs}" element="li"/>
                </td>
                <td>
                    <form:errors path="sex" class="error-message"/>
                </td>
            </tr>
            <tr>
                <td>
                    Roles:
                </td>
                <td>
                    <form:checkboxes path="roles" items="${user.rolesMap}" element="li"/>
                </td>
                <td>

                </td>
            </tr>
        </table>

        <button type="submit">Register me</button>
        <button type="button" onclick="window.location.href='/'">Go main page</button>
    </form:form>

</body>
</html>
