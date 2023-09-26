<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>ȸ������</title>
    <!-- Bootstrap CDN ��ũ �߰� -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.7.0/dist/css/bootstrap.min.css">
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

        /* ���� ��Ÿ�� ���� */

        .form-container {
            width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        /* ���� ��Ÿ�� ���� */

        .form-container label {
            display: block;
            margin-bottom: 5px;
        }

        /* ���� ��Ÿ�� ���� */

        .form-container input[type="text"],
        .form-container input[type="password"],
        .form-container input[type="email"],
        .form-container input[type="number"],
        .form-container input[type="date"],
        .form-container input[type="submit"] {
            padding: 8px;
            width: 100%;
            border: 1px solid #ddd;
            border-radius: 3px;
            margin-bottom: 10px;
        }

        /* ���� ��Ÿ�� ���� */

        .form-container input[type="radio"] {
            margin-right: 5px;
        }

        /* ���� ��Ÿ�� ���� */

        .form-container input[type="submit"] {
            display: block;
            width: 100%;
            padding: 8px;
            margin-top: 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        /* ���� ��Ÿ�� ���� */

        .form-container input[type="submit"]:hover {
            background-color: #0056b3;
        }

        /* ���� ��Ÿ�� ���� */

        .link {
            text-align: center;
            margin-top: 20px;
        }

        /* ���� ��Ÿ�� ���� */

    </style>
</head>
<body>
<h1>ȸ������</h1>
<div class="form-container">
    <form action="insertUser.do" method="post">
        <div class="mb-3">
            <label for="id" class="form-label">���̵�</label>
            <input type="text" class="form-control" id="id" name="id">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">��й�ȣ</label>
            <input type="password" class="form-control" id="password" name="password">
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">�̸�</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="mb-3">
            <label for="birth" class="form-label">�������</label>
            <input type="date" class="form-control" id="birth" name="birth">
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" name="email">
        </div>
        <div class="mb-3">
            <label for="phone" class="form-label">�޴�����ȣ</label>
            <input type="number" class="form-control" id="phone" name="phone">
        </div>
        <div class="mb-3">
            <label class="form-label">����</label>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" id="admin" name="role" value="admin" checked>
                <label class="form-check-label" for="admin">������</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" id="user" name="role" value="User">
                <label class="form-check-label" for="user">�����</label>
            </div>
        </div>
        <div>
            <input type="submit" value="ȸ������" class="btn btn-primary">
        </div>
    </form>
</div>
<div class="link">
    <a href="/WebMyLibProject/login.jsp">�α���</a>
</div>
<div class="link">
    <a href="/WebMyLibProject/homepage.jsp">���ư���</a>
</div>
<!-- Bootstrap ��ũ��Ʈ ��ũ �߰� -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.7.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>