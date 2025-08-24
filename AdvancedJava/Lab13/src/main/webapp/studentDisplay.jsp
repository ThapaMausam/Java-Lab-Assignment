<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Information</title>
</head>
<body>
    <h2>Student Information Submitted</h2>
    
    <p><b>Form submitted successfully!</b></p>
    
    <table border="1">
        <tr>
            <td><b>Name:</b></td>
            <td><%= request.getParameter("name") %></td>
        </tr>
        <tr>
            <td><b>Email:</b></td>
            <td><%= request.getParameter("email") %></td>
        </tr>
    </table>
    
    <br>
    <a href="studentForm.jsp">Go Back to Form</a>
</body>
</html>