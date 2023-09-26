<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>����'s ������</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <style>
        body {
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
        margin: 0;
        padding: 0;
    }

    header {
        background-color: #007bff; /* ����: �׺���̼� �� ���� */
        color: #fff;
        padding: 10px;
    }

    /* ���� ��Ÿ�� ���� */

    .navbar {
        background-color: #f8f8f8;
        padding: 10px;
    }

    /* ���� ��Ÿ�� ���� */

    .content {
        background-color: #fff;
        padding: 20px;
        margin-top: 20px;
    }
    </style>
</head>
<body>
<header>
    <div class="container">
        <h1>����'s ������</h1>
    </div>
</header>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <c:choose>
                    <c:when test="${ empty user_id }">
                        <li class="nav-item">
                            <a class="nav-link" href="/WebMyLibProject/getBookList.do">��ü�������</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/WebMyLibProject/searchBook.do">�����˻�</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/WebMyLibProject/login.do">�α���</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/WebMyLibProject/searchId.do">���̵� ã��</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/WebMyLibProject/searchPassword.do">��й�ȣ ã��</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/WebMyLibProject/insertUser.jsp">ȸ������</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${ user.role == 'admin' }">
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/addBook.jsp">å�԰�</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/deleteBook.jsp">å����</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/getAllRentalList.do">�뿩������ü����</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/getBookList.do">��ü�������</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/searchBook.do">�����˻�</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/userList.do">ȸ�����</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/logout.do">�α׾ƿ�</a>
                            </li>
                        </c:if>
                        <c:if test="${ user.role != 'admin' }">
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/getBookList.do">��ü�������</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/searchBook.do">�����˻�</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/returnBookList.do">�뿩���ε���</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/addRent.jsp">å�뿩</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/returnBook.jsp">å�ݳ�</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/userInfo.do">����������</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/logout.do">�α׾ƿ�</a>
                            </li>
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>
<section class="content">
    <div class="container">
        <c:choose>
            <c:when test="${ not empty user_id }">
                <h2>${user.name}�� ȯ���մϴ�!</h2>
            </c:when>
        </c:choose>
        <hr/>
        <!-- ���⿡ ���α׷� ���� �߰� -->
    </div>
</section>
<!-- Bootstrap JavaScript �� jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>