<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>도서 목록</title>
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

        section {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }

        form {
            margin-bottom: 20px;
            text-align: center;
        }

        input[type="text"] {
            padding: 5px;
            width: 300px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #007bff;
            color: #fff;
        }

        tbody tr:nth-child(even) {
            background-color: #f2f2f2;
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
    <section>
        <h1>도서 목록</h1>

        <form action="searchBook.do" method="POST">
            <input type="text" name="bookinfo" placeholder="도서 정보 입력">
            <input type="submit" value="검색">
        </form>

        <table border="1">
            <thead>
                <tr>
                    <th>ISBN</th>
                    <th>도서명</th>
                    <th>저자</th>
                    <th>출판사</th>
                    <th>수령일</th>
                    <th>대출 가능 여부</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${bookList}">
                    <tr>
                        <td>${book.isbn}</td>
                        <td>${book.name}</td>
                        <td>${book.writer}</td>
                        <td>${book.publisher}</td>
                        <td>${book.receive}</td>
                        <td>
                            <c:if test="${book.rentable}">
                                대출 가능
                            </c:if>
                            <c:if test="${!book.rentable}">
                                대출 불가능
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </section>
    <div class="link">
        <a href="/WebMyLibProject/homepage.jsp">돌아가기</a>
    </div>
</body>
</html>