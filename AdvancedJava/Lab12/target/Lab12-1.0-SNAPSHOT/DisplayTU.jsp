<%-- 
    Document   : DisplayTU
    Created on : Aug 11, 2025, 4:28:50 PM
    Author     : mausamthapa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lab 11</title>
    </head>
    <body>
        <h2>Displaying "Tribhuvan University" 10 times</h2>
        <%! int i; %>
        <%-- Scriptlets --%>
        <%
            for (i = 0; i < 10; i++) {
        %>
            <p>Tribhuvan University</p>
        <%
            }
        %>
        
    </body>
</html>
