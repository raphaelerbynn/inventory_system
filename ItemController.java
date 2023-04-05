import java.util.*;

public class ItemController {
    List<Item> items = new ArrayList<>();;
    Stack<Item> itemStack = new Stack<>();
    Queue<Item> itemQueue = new LinkedList<>();
    private Map<String, Vendor> vendors;

    public ItemController() {
        this.vendors = new HashMap<>();
    }

    public void addItemToDataStructure(Item item) {
        // category structure
        if (item.getCategory().equals("Beverages") ||
                item.getCategory().equals("Bakery") ||
                item.getCategory().equals("Bread") ||
                item.getCategory().equals("Canned") ||
                item.getCategory().equals("Jarred Goods") ||
                item.getCategory().equals("Dairy")) {

            itemStack.push(item);
            System.out.printf("Type of data structure by category: %s\n", itemStack.getClass());

        } else if (item.getCategory().equals("Dry/Baking Goods") ||
                item.getCategory().equals("Frozen Foods") ||
                item.getCategory().equals("Meat")) {

            itemQueue.add(item);
            System.out.printf("Type of data structure by category: %s\n", itemStack.getClass());

        } else {

            this.items.add(item);
            System.out.printf("Type of data structure by category: %s\n", itemStack.getClass());
        }

    }


    public void removeItem(Item item) {

        if (item.getCategory().equals("Beverages") ||
                item.getCategory().equals("Bread/Bakery") ||
                item.getCategory().equals("Canned/Jarred Goods") ||
                item.getCategory().equals("Dairy")) {

            itemStack.remove(item);

        } else if (item.getCategory().equals("Dry/Baking Goods") ||
                item.getCategory().equals("Frozen Foods") ||
                item.getCategory().equals("Meat")) {

            itemQueue.remove(item);

        } else {

            this.items.remove(item);
        }
    }

    public void updateItemQuantity(Item item, int newQuantity) {
        item.setQuantity(newQuantity);
    }

    public List<Item> getItemsByCategory(String category) {
        List<Item> matchingItems = new ArrayList<>();
        for (Item item : items) {
            if (item.getCategory().equals(category)) {
                matchingItems.add(item);
            }
        }
        return matchingItems;
    }

    public List<Item> getItemsByVendor(String id) {
        List<Item> matchingItems = new ArrayList<>();
        Vendor vendor = vendors.get(id);
        if (vendor != null) {
            for (Item item : items) {
                if (item.getVendorId().equals(vendor)) {
                    matchingItems.add(item);
                }
            }
        }
        return matchingItems;
    }

    public int getTotalInventory() {
        int total = 0;
        for (Item item : items) {
            total += item.getQuantity();
        }
        return total;
    }
}
