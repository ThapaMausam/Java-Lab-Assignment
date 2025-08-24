import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    
    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/student_data?useSSL=false&serverTimezone=UTC&zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "0m2!9QEL";
    
    // Handle GET request - Show form and display all students
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h2>Student Database Example</h2>");
        
        // Display form
        out.println("<h3>Add New Student</h3>");
        out.println("<form method='post'>");
        out.println("Name: <input type='text' name='name' required><br><br>");
        out.println("Email: <input type='email' name='email' required><br><br>");
        out.println("<input type='submit' value='Add Student'>");
        out.println("</form>");
        
        out.println("<hr>");
        
        // Display all students from database
        out.println("<h3>All Students</h3>");
        displayStudents(out);
        
        out.println("</body></html>");
    }
    
    // Handle POST request - Add new student to database
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        
        // Add student to database
        addStudent(name, email);
        
        // Redirect back to GET method to show updated list
        response.sendRedirect("StudentServlet");
    }
    
    // Method to add student to database
    private void addStudent(String name, String email) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String sql = "INSERT INTO students (name, email) VALUES (?, ?)";
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                
                stmt.setString(1, name);
                stmt.setString(2, email);
                stmt.executeUpdate();
            }
            
        } catch (Exception e) {
            System.err.println("Error adding student: " + e.getMessage());
        }
    }
    
    // Method to display all students from database
    private void displayStudents(PrintWriter out) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String sql = "SELECT * FROM students ORDER BY id";
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                
                out.println("<table border='1'>");
                out.println("<tr><th>ID</th><th>Name</th><th>Email</th></tr>");
                
                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getInt("id") + "</td>");
                    out.println("<td>" + rs.getString("name") + "</td>");
                    out.println("<td>" + rs.getString("email") + "</td>");
                    out.println("</tr>");
                }
                
                out.println("</table>");
            }
            
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }
}