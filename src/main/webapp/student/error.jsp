<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Error Page</title>
    <link rel="stylesheet" href="style.css" />
</head>
<body>

<table>
    <tbody>
    <tr>
        <th>상태 코드</th>
        <td><c:out value="${status_code}"/></td>
    </tr>
    <tr>
        <th>예외 유형</th>
        <td><c:out value="${exception_type}"/></td>
    </tr>
    <tr>
        <th>메시지</th>
        <td><c:out value="${message}"/></td>
    </tr>
    <tr>
        <th>예외</th>
        <td><c:out value="${exception}"/></td>
    </tr>
    <tr>
        <th>요청 URI</th>
        <td><c:out value="${request_uri}"/></td>
    </tr>
    </tbody>
</table>
</body>
</html>
