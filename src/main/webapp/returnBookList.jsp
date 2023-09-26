<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>���� ���</title>
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
    <h1>���� ���</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>ISBN</th>
            <th>������</th>
            <th>����� ID</th>
            <th>�뿩��</th>
            <th>�ݳ���</th>
        </tr>
        <c:forEach items="${rentals}" var="rental">
            <tr>
                <td>${rental.rental_id}</td>
                <td>${rental.isbn}</td>
                <td>${rental.name}</td>
                <td>${rental.user_id}</td>
                <td>${rental.rent}</td>
                <td>${rental.receive}</td>
            </tr>
        </c:forEach>
    </table>
    <div class="link">
        <a href="/WebMyLibProject/homepage.jsp">���ư���</a>
    </div>
</body>
</html>





