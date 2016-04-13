<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Телефонный справочник</title>
</head>
<body>
<a href="${pageContext.servletContext.contextPath}/views/user/CreateUser.jsp">Добавить абонента</a>
<a href="${pageContext.servletContext.contextPath}/views/user/SearchUser.jsp">Искать абонента</a>
<a href="${pageContext.servletContext.contextPath}/user/view">Показать всех абонентов</a>

<br/>
<br/>
<c:out value="${error}" default="" />
<br/>
<br/>

<c:if test="${!empty users}" >

<table style="
    font-size: 18px;
    text-align: left;
" >
    <tr>
        <td>Имя</td>
        <td>Номер</td>
        <td>Действие</td>
    </tr>
    <c:forEach items="${users}" var="user" varStatus="status">
        <tr valign="top">
            <td>${user.name}</td>
            <td>${user.number}</td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/user/delete?id=${user.id}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>

</c:if>

</body>
</html>