<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Spring mvc</title>
</head>
<body>
    <br><br><br>
    <table border="1" cellpadding="10">
        <tr>
            <th>name</th>
            <th>surname</th>
            <th>department</th>
            <th>salary</th>
            <th colspan="2">operations</th>
        </tr>
        <c:forEach var="emp" items="${allEmps}">
            <c:url var="updateButton" value="/updateInfo">
                <c:param name="empId" value="${emp.id}"/>
            </c:url>
            <c:url var="deleteButton" value="/deleteEmployee">
                <c:param name="empId" value="${emp.id}"/>
            </c:url>
            <tr>
                <td>${emp.name}</td>
                <td>${emp.surname}</td>
                <td>${emp.department}</td>
                <td>${emp.salary}</td>
                <td>
                    <input type = "button" value = "Edit" 
                        onclick = "window.location.href='${updateButton}'"/>
                </td>
                <td>
                    <input type = "button" value = "Delete" 
                        onclick = "window.location.href='${deleteButton}'"/>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <input type="button" value="Add" onclick="window.location.href='addNewEmployee'"/>

</body>
</html>
