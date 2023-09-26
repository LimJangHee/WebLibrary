<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>ID 찾기</title>
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

        .form-container input[type="text"],
        .form-container input[type="date"] {
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
    <h1>ID 찾기</h1>
    
    <div class="form-container">
        <form action="searchId.do" method="post">
            <div>
                <label for="name">이름을 입력해주세요:</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div>
                <label for="birth">생일:</label>
                <input type="date" id="birth" name="birth" required>
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