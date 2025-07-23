package databasecrudoperations;

import java.sql.*;

public class DatabaseCRUDOperations {
    
    private static final String URL = "jdbc:mysql://localhost:3306/student_db?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "0m2!9QEL";
    
    public static void main(String[] args) {
        createStudentTable();
        insertStudent("Kishor", 22);
        insertStudent("Kshitiz", 23);
        readAllStudents();
        updateStudent(1, "Mausam Updated", 21);
        deleteStudent(2);
        readAllStudents();
    }
    
    private static void createStudentTable() {
        String sql = """
                     CREATE TABLE IF NOT EXISTS students (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        age INT NOT NULL
                     )
                     """;
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table successfully created/exists.");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }
    
    private static void insertStudent(String name, int age) {
        String sql = "INSERT INTO students (name, age) VALUES (?, ?)";
        
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.executeUpdate();
            System.out.println(name + " data inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting student: " + e.getMessage());
        }
    }
    
    private static void readAllStudents() {
        String sql = "SELECT * FROM students";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Age: " + rs.getInt("age"));
            }
        } catch (SQLException e) {
            System.out.println("Error reading students: " + e.getMessage());
        }
    }
    
    private static void updateStudent(int id, String name, int age) {
         String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";
         try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
             pstmt.setString(1, name);
             pstmt.setInt(2, age);
             pstmt.setInt(3, id);
             int rowsAffected = pstmt.executeUpdate();
             if (rowsAffected > 0) {
                 System.out.println("Student updated Successfully.");
             } else {
                 System.out.println("No student found with id " + id);
             }
         } catch (SQLException e) {
             System.out.println("Error Updating students: " + e.getMessage());
         }
     }
     
    private static void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("No student found with ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}