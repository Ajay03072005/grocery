import java.util.*;

public class Cart {
    Map<Product, Integer> items = new HashMap<>();

    public void addToCart(Product product, int qty) {
        items.put(product, items.getOrDefault(product, 0) + qty);
        System.out.println("Added to cart.");
    }

    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("🛒 Cart is empty.");
            return;
        }

        double total = 0;
        System.out.println("Your Cart:");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            double cost = p.price * qty;
            total += cost;
            System.out.printf("%s x %d = ₹%.2f\n", p.name, qty, cost);
        }
        System.out.printf("Total: ₹%.2f\n", total);
    }

    public void checkout() {
        if (items.isEmpty()) {
            System.out.println("❌ Cart is empty. Add items first.");
            return;
        }

        viewCart();
        System.out.println("Proceeding to checkout...");
        items.clear();
        System.out.println("Checkout successful. Thank you!");
    }
}
