<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>尼玛论坛登录</title>
</head>
<body>
    <c:if test="${!empty error}">
        <font color="red"/><c:out value="${error}"/>
    </c:if>
    <form action="<c:url value="/loginCheck.html"/>" method="post">
        <input type="text" name="userName"><br>
        <input type="password" name="password"><br>
        <input type="submit" value="登录">&nbsp;&nbsp;
        <input type="reset" value="重置">
    </form>
</body>
</html>
