<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Spring mvc</title>
</head>
<body>
    <br><br><br>
    <form:form action="saveEmployee" modelAttribute="employee">
        <form:hidden path="id"/>
        <table border="1" cellpadding="10">
            <tr>
                <td>name
                <td><form:input path="name"/>
            <tr>
                <td>surname
                <td><form:input path="surname"/>
            <tr>
                <td>department
                <td><form:input path="department"/>
            <tr>
                <td>salary
                <td><form:input path="salary"/>
        </table>
        <br>
        <input type="submit" value="Save"> 
        <input type = "button" value = "Main" 
            onclick = "window.location.href='/'"/>
    </form:form>  
    
</body>
</html>
