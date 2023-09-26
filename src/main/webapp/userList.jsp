<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>사용자 정보</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            margin-top: 50px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #007bff;
            color: #fff;
        }

        tr:hover {
            background-color: #f2f2f2;
        }

        .link {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h1>사용자 정보</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>PW</th>
            <th>이름</th>
            <th>생일 ID</th>
            <th>email</th>
            <th>phone</th>
            <th>role</th>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.password}</td>
                <td>${user.name}</td>
                <td>${user.birth}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td>${user.role}</td>
            </tr>
        </c:forEach>
    </table>
    <div class="link">
        <a href="/WebMyLibProject/homepage.jsp">돌아가기</a>
    </div>
</body>
</html>