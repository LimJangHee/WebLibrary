<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>ȸ�� ���� ����</title>
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

        form {
            max-width: 500px;
            margin: 30px auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 3px;
        }

        input[type="submit"] {
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

        .message {
            margin-top: 20px;
            padding: 10px;
            background-color: #f2f2f2;
            border: 1px solid #ddd;
            border-radius: 3px;
        }

        .link {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h1>ȸ�� ���� ����</h1>
    <form action="userUpdate.do" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <label for="password">��й�ȣ</label>
        <input type="password" id="password" name="password" required>
        <label for="name">�̸�</label>
        <input type="text" id="name" name="name" value="${user.name}" required>
        <label for="birth">����</label>
        <input type="date" id="birth" name="birth" value="${user.birth}" required>
        <label for="email">�̸���</label>
        <input type="text" id="email" name="email" value="${user.email}" required>
        <label for="phone">��ȭ��ȣ</label>
        <input type="text" id="phone" name="phone" value="${user.phone}" required>
        <label for="role">����</label>
        <input type="text" id="role" name="role" value="${user.role}" required>
        <input type="submit" value="����">
    </form>
    <div class="link">
        <a href="/WebMyLibProject/userInfo.do">���ư���</a>
    </div>
</body>
</html>