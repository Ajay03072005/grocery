import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    static final String URL = "jdbc:mysql://localhost:3306/grocery_kart";
    static final String USER = "root";
    static final String PASSWORD = "Ajay";

    public static List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM groceries");

            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")));
            }

            con.close();
        } catch (Exception e) {
            System.out.println("DB Error: " + e.getMessage());
        }
        return list;
    }

    public static void addProduct(String name, double price, int quantity) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO groceries (name, price, quantity) VALUES (?, ?, ?)"
            );
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setInt(3, quantity);
            ps.executeUpdate();
            con.close();
            System.out.println("✅ Product added successfully.");
        } catch (Exception e) {
            System.out.println("Insert Error: " + e.getMessage());
        }
    }
}
