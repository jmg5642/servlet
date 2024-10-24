<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
  <title>student - list</title>
  <link rel="stylesheet" href="/style.css" />
  <style>
    table {
      width: 70%;
      border-collapse: collapse;
      border: 1px solid #ccc;
    }
    th, td {
      padding: 10px;
      border: 1px solid #ccc;
    }
  </style>
</head>

<body>
<h1>학생 리스트</h1>
<p><a href="/student/register.do" >학생(등록)</a></p>
<table border="1">
  <thead>
  <tr>
    <th>아이디</th>
    <th>이름</th>
    <th>성별</th>
    <th>나이</th>
    <th>cmd</th>
  </tr>
  </thead>
  <tbody>
  <!-- 학생 리스트를 반복하여 출력 -->
  <c:forEach var="item" items="${studentList}">
    <tr>
      <td>${item.id}</td>
      <td>${item.name}</td>
      <td>${item.gender}</td>
      <td>${item.age}</td>
      <td><a href="/student/view.do?id=${item.id}" style="color: purple;">조회</a></td> <!-- cmd 열에 '조회' 링크 -->
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
