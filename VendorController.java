import java.util.*;

public class VendorController {
    private HashMap<String, Vendor> vendors;

    public VendorController() {
        vendors = new HashMap<String, Vendor>();
    }

    public void addVendor(String id, String name, String address, String phone, String email) {
        Vendor vendor = new Vendor(id, name, phone);
        vendors.put(id, vendor);
    }

    public void removeVendor(String id) {
        vendors.remove(id);
    }

    public void updateVendor(String vendorCode, String vendorName, String vendorAddress, String vendorPhone) {
        Vendor vendor = vendors.get(vendorCode);
        if (vendor != null) {
            vendor.setName(vendorName);
            vendor.setPhone(vendorPhone);
        }
    }

    public List<Vendor> getAllVendors() {
        List<Vendor> vendorList = new ArrayList<Vendor>(vendors.values());
        Collections.sort(vendorList);;
        return vendorList;
    }

    public Vendor getVendor(String vendorCode) {
        return vendors.get(vendorCode);
    }
}
