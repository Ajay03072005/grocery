import java.sql.*;

public class viewGroceries {
    public static void viewGroceries() {
        System.out.println("Fetching groceries from database...");

        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the MySQL database
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/grocery_kart", "root", "Ajay");

            // Create SQL query
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM groceries");

            // Print the result
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1)
                        + ", Name: " + rs.getString(2)
                        + ", Quantity: " + rs.getInt(3)
                        + ", Price: ₹" + rs.getDouble(4));
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
