<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>전체대출리스트</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #007bff;
            padding: 20px;
            color: #fff;
            text-align: center;
        }

        h3 {
            margin-top: 0;
        }

        hr {
            border: none;
            height: 1px;
            background-color: #fff;
            margin: 10px 0;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        table th,
        table td {
            padding: 10px;
            border: 1px solid #ccc;
        }

        .link {
            text-align: center;
            margin-top: 20px;
        }

        .link a {
            color: #007bff;
            text-decoration: none;
        }

        .link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<header>
    전체대출중인도서
    
    <hr/>
</header>
<section>
    <table>
        <tr>
            <th>RENTAL_ID</th>
            <th>ISBN</th>
            <th>NAME</th>
            <th>USER_ID</th>
            <th>RENT</th>
            <th>RECEIVE</th>
        </tr>
        <c:forEach var="rental" items="${rentalList}">
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
</section>
<div class="link">
    <a href="/WebMyLibProject/homepage.jsp">돌아가기</a>
</div>
</body>
</html>