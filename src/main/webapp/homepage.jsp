<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>장희's 도서관</title>
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
        background-color: #007bff; /* 수정: 네비게이션 바 색상 */
        color: #fff;
        padding: 10px;
    }

    /* 기존 스타일 유지 */

    .navbar {
        background-color: #f8f8f8;
        padding: 10px;
    }

    /* 기존 스타일 유지 */

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
        <h1>장희's 도서관</h1>
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
                            <a class="nav-link" href="/WebMyLibProject/getBookList.do">전체도서목록</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/WebMyLibProject/searchBook.do">도서검색</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/WebMyLibProject/login.do">로그인</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/WebMyLibProject/searchId.do">아이디 찾기</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/WebMyLibProject/searchPassword.do">비밀번호 찾기</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/WebMyLibProject/insertUser.jsp">회원가입</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${ user.role == 'admin' }">
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/addBook.jsp">책입고</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/deleteBook.jsp">책삭제</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/getAllRentalList.do">대여중인전체도서</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/getBookList.do">전체도서목록</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/searchBook.do">도서검색</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/userList.do">회원목록</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/logout.do">로그아웃</a>
                            </li>
                        </c:if>
                        <c:if test="${ user.role != 'admin' }">
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/getBookList.do">전체도서목록</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/searchBook.do">도서검색</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/returnBookList.do">대여중인도서</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/addRent.jsp">책대여</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/returnBook.jsp">책반납</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/userInfo.do">마이페이지</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/WebMyLibProject/logout.do">로그아웃</a>
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
                <h2>${user.name}님 환영합니다!</h2>
            </c:when>
        </c:choose>
        <hr/>
        <!-- 여기에 프로그램 내용 추가 -->
    </div>
</section>
<!-- Bootstrap JavaScript 및 jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>