package com.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import jakarta.servlet.ServletException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // Processing Forms
        
        // 1. Read Parameters
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        // Set Content type
            res.setContentType("text/html");
            
            // Create PrintWriter object
            PrintWriter writer = res.getWriter();
        
        // 2. Set Action
        if ("Mausam".equals(username) && "admin123".equals(password)) {
            // HTML
            writer.println("""
                           <html>
                           <body>
                           <h2>Login Successful!</h2>
                           <p>Welcome, 
                           """ + username + """
                                            !</p>
                                            </body>
                                            </html>
                                            """);
        } else {
            writer.println("""
                           <html>
                           <body>
                           <h2>Login Failed!</h2>
                           <p>Invalid username or password.</p>
                           </body>
                           </html>
                            """);
        }
    }
}