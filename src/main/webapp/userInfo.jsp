<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>마이 페이지</title>
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
    <h1>마이 페이지</h1>
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
        <c:forEach items="${userList}" var="userList">
            <tr>
                <td>${userList.id}</td>
                <td>${userList.password}</td>
                <td>${userList.name}</td>
                <td>${userList.birth}</td>
                <td>${userList.email}</td>
                <td>${userList.phone}</td>
                <td>${userList.role}</td>
            </tr>
        </c:forEach>
    </table>
    <div class="link">
        <a href="/WebMyLibProject/homepage.jsp">돌아가기</a>
    </div>
    <div class="link">
        <a href="/WebMyLibProject/userUpdate.jsp">개인정보수정</a>
    </div>
    <div class="link">
        <a href="/WebMyLibProject/userDelete.jsp">회원탈퇴</a>
    </div>
</body>
</html>