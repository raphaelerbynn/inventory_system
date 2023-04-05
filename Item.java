import java.util.*;

public class Item {
    private int id;
    private String name;
    private String category;
    private int quantity;
    private double price;
    private String vendor_id;

    // Constructor
    public Item(String name, String category, int quantity, double price, String vendor_id) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.vendor_id = vendor_id;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getVendorId() {
        return vendor_id;
    }

    public void setVendorId(String vendor_id) {
        this.vendor_id = vendor_id;
    }

    // toString method
    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + ", category=" + category + ", quantity=" + quantity + ", price="
                + price + "]";
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        return id == other.id && Objects.equals(name, other.name) && Objects.equals(category, other.category)
                && quantity == other.quantity && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(name, category, quantity, price);
    }
}
