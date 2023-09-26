<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>PW 찾기</title>
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

        .form-container {
            width: 300px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        .form-container label {
            display: block;
            margin-bottom: 10px;
        }

        .form-container input[type="text"] {
            padding: 8px;
            width: 100%;
            border: 1px solid #ddd;
            border-radius: 3px;
        }

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

        .form-container input[type="submit"]:hover {
            background-color: #0056b3;
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
    <h1>PW 찾기</h1>
    
    <div class="form-container">
        <form action="searchPassword.do" method="post">
            <div>
                <label for="id">ID를 입력해주세요:</label>
                <input type="text" id="id" name="id" required>
            </div>
            <div>
                <label for="phone">핸드폰 번호를 입력해주세요:</label>
                <input type="text" id="phone" name="phone" required>
            </div>
            <div>
                <input type="submit" value="찾기">
            </div>
        </form>
    </div>
    
    <div class="link">
        <a href="/WebMyLibProject/homepage.jsp">돌아가기</a>
    </div>
</body>
</html>