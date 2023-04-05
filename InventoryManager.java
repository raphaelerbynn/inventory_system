import java.util.*;
import java.sql.*;

public class InventoryManager {
    ItemController IC = new ItemController();
    private Map<String, Vendor> vendors;

    Connection connection = Database.getConnection();

    public InventoryManager() {
        this.vendors = new HashMap<>();
    }

    
    public void insertItemsToDb() {
        try {
            String sql = "INSERT INTO item (name, category, price, id_vendor) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            // Looping through the datatype items inserting them into the database

            
            for (Item item : IC.items) {
                statement.setString(1, item.getName());
                statement.setString(2, item.getCategory());
                statement.setDouble(3, item.getPrice());
                statement.setString(4, item.getVendorId());
                statement.executeUpdate();
            }

            for (Item item : IC.itemQueue) {
                statement.setString(1, item.getName());
                statement.setString(2, item.getCategory());
                statement.setDouble(3, item.getPrice());
                statement.setString(4, item.getVendorId());
                statement.executeUpdate();
            }

            for (Item item : IC.itemStack) {
                statement.setString(1, item.getName());
                statement.setString(2, item.getCategory());
                statement.setDouble(3, item.getPrice());
                statement.setString(4, item.getVendorId());
                statement.executeUpdate();
            }

            statement.close();
            System.out.println("Data saved");
            Database.closeConnection();
        } 
        catch(SQLIntegrityConstraintViolationException e){
            System.out.println("Vendor with this id does not exist");
            System.out.println(e);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addVendor(String vendor_id, Vendor vendor) {
        this.vendors.put(vendor_id, vendor);
    }

    

    public void removeVendor(String name) {
        this.vendors.remove(name);
    }

    // Other methods for interacting with items, vendors, and bills could be added
    // here
}
