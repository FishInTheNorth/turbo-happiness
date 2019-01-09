<%--
  Created by IntelliJ IDEA.
  User: zk
  Date: 2019/1/8
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<c:if test="${empty sessionScope.userName}">
    <c:redirect url="login.jsp?f=5" />
</c:if>
<head>
    <title>Title</title>
</head>
<body>
 <c:remove var="userName" scope="session" />
 <c:redirect url="login.jsp" />
</body>
</html>
