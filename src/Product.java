public class Product {
    int id;
    String name;
    double price;
    int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void display() {
        System.out.printf("ID: %d | Name: %s | Price: ₹%.2f | Stock: %d\n", id, name, price, quantity);
    }
}
