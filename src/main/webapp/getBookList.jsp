<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>전체도서검색</title>
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
    전체도서검색
   
    <hr/>
</header>
<section>
    <table>
        <tr>
            <th>ISBN</th>
            <th>도서명</th>
            <th>저자</th>
            <th>출판사</th>
            <th>반납날짜</th>
            <th>대출 가능 여부</th>
        </tr>
        <c:forEach var="book" items="${bookList}">
            <tr>
                <td>${book.isbn}</td>
                <td>${book.name}</td>
                <td>${book.writer}</td>
                <td>${book.publisher}</td>
                <td>${book.receive}</td>
                <td>
                    <c:choose>
                        <c:when test="${book.rentable}">대출 가능</c:when>
                        <c:otherwise>대출 불가능</c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
</section>
<div class="link">
    <a href="/WebMyLibProject/homepage.jsp">돌아가기</a>
</div>
</body>
</html>