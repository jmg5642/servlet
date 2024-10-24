<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--<%@ taglib prefix="cfmt" uri="http://nhnacademy.com/cfmt" %>--%>
<html>
<head>
  <title>학생-조회</title>
  <link rel="stylesheet" href="/style.css" />
  <style>
    table {
      width: 50%;
      border-collapse: collapse;
      border: 1px solid #ccc;
    }
    tr{
      height: 30px;
    }
  </style>
</head>
<body>
<table border="1">
  <tbody>
  <c:set var="student" value="${student}" scope="request" />
  <tr>
    <th>아이디</th>
    <td>${student.id}</td>
  </tr>
  <tr>
    <th>이름</th>
    <td>${student.name}</td>
  </tr>
  <tr>
    <th>성별</th>
    <td>${student.gender}</td>
  </tr>
  <tr>
    <th>나이</th>
    <td>${student.age}</td>
  </tr>
  <tr>
    <th>등록일</th>
    <td>${student.createAt}</td>
  </tr>
  </tbody>
</table>
<ul>
  <li><a href="/student/list.do">리스트</a></li>
  <li>
    <a href="<c:url value='/student/update.do?id=${student.id}'/>">수정</a>
  </li>
  <li>
    <form action="<c:url value='/student/delete.do?id=${student.id}'/>" method="post">
      <button type="submit">삭제</button>
    </form>
  </li>
</ul>

</body>
</html>
