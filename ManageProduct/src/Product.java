
/**
 * Product class
 */
public class Product {
    String id;
    String title;
    int quantity;
    double price;


    /**
     * Constructor method to initialize a product
     *
     * @param id    Product's bar code
     * @param title    Product's title
     * @param quantity Product's quantity
     * @param price    Product's price
     */
    public Product(String id, String title, Integer quantity, double price) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Convert this product to String for printing
     */
    @Override
    public String toString() {
        String s = String.format("%-4s | %-12s | %-8d | %-5.1f", id, title, quantity, price);
        return s;
    }

}