import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Cart cart = new Cart();

    public static void main(String[] args) {
        System.out.println("====== Grocery Kart Console App ======");
        while (true) {
            System.out.println("""
                    
                    1. View Groceries
                    2. Add to Cart
                    3. View Cart
                    4. Checkout
                    5. Add Grocery (Admin)
                    6. Exit
                    """);
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> viewGroceries.viewGroceries();
                case 2 -> addToCart();
                case 3 -> cart.viewCart();
                case 4 -> cart.checkout();
                case 5 -> addGrocery();
                case 6 -> {
                    System.out.println("Exiting Grocery Kart...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void viewGroceries() {
        List<Product> products = ProductDAO.getAllProducts();
        for (Product p : products) p.display();
    }

    static void addToCart() {
        viewGroceries();
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        Product selected = null;
        for (Product p : ProductDAO.getAllProducts()) {
            if (p.id == id) selected = p;
        }

        if (selected != null) {
            cart.addToCart(selected, qty);
        } else {
            System.out.println("Product not found.");
        }
    }

    static void addGrocery() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter price: ");
        double price = sc.nextDouble();
        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();
        ProductDAO.addProduct(name, price, qty);
    }
}
