<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>Process Page</title>
    <script>
        function showAlert(message, nextJsp) {
            alert(message);
            window.location.href = nextJsp;
        }
    </script>
</head>
<body>
    <%
        // Get the message and next JSP path from the request attributes
        String message = (String) request.getAttribute("message");
        String nextJsp = (String) request.getAttribute("nextJsp");
    %>
    
    <script>
        // Call the showAlert function with the message and next JSP path
        showAlert('<%= message %>', '<%= nextJsp %>');
    </script>
</body>
</html>