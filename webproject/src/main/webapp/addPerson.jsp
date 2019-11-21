<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ${USER}
  Date: ${DATE}
  Time: ${TIME}
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/persons" method="post">
    <label>id</label>
    <input type="text" name="id" value="<c:out value='${person.id}'/>"/>
    </br>
    <label>name</label>
    <input type="text" name="name" value="<c:out value='${person.name}'/>"/>
    </br>
    <label>age</label>
    <input type="text" name="age" value="<c:out value='${person.age}'/>"/>

    <button type="submit">Add user</button>
</form>
</body>
</html>