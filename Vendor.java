public class Vendor implements Comparable<Vendor>{
    private String id;
    private String name;
    private String phone;

    public Vendor(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Phone: %s ",
                id, name, phone);
    }

    @Override
    public int compareTo(Vendor otherVendor) {
        return this.getName().compareTo(otherVendor.getName());
    }
}

