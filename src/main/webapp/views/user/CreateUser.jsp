<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Добавить абонента</title>
</head>
<body>
    <form action="${pageContext.servletContext.contextPath}/user/create" method="POST" >
        <table>
            <tr>
                <td>Имя:</td>
                <td>
                    <input type="text" name="name">
                </td>
            </tr>
            <tr>
                <td>Номер</td>
                <td>
                    <input type="text" name="number">
                </td>
            </tr>
            <tr>
                <td><input type="submit" align="center" value="Добавить" /></td>
            </tr>
        </table>
    </form>

</body>
</html>
