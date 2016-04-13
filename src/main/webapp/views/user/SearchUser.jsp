<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Поиск абонента</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/user/search" method="POST" >
    <table>
        <tr>
            <td align="right">Введите имя или некоторые символы искомого имени:</td>
            <td align="right">
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Искать" /></td>
        </tr>
    </table>
</form>

</body>
</html>
