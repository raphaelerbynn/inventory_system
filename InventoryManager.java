import java.util.*;
import java.sql.*;

public class InventoryManager {
    ItemController IC = new ItemController();
    private Map<String, Vendor> vendors;

    Connection connection = Database.getConnection();

    public InventoryManager() {
        this.vendors = new HashMap<>();
    }

    public void fetchAllItems() {
        try {
            String sql = "SELECT * FROM item";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                String name = result.getString("name");
                String category = result.getString("category");
                int quantity = result.getInt("quantity");
                double price = result.getDouble("quantity");

                Item item = new Item(name, category, quantity, price, category);
                IC.addItemToDataStructure(item);
            }
           
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
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

    public void insertVendorToDb(String vendor_id) {
        try {
            String sql = "INSERT INTO vendor (id_vendor, name, contact) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
        
            statement.setString(1, vendors.get(vendor_id).getId());
            statement.setString(2, vendors.get(vendor_id).getName());
            statement.setString(3, vendors.get(vendor_id).getPhone());
        
            statement.close();
            System.out.println("Data saved");
            Database.closeConnection();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void addVendor(String vendor_id, Vendor vendor) {
        this.vendors.put(vendor_id, vendor);
    }

}
