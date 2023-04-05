import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        InventoryManager IM = new InventoryManager();
        Scanner sc = new Scanner(System.in);
        
        Boolean keepAdding = true;

        System.out.println("Enter items (name, quantity, price, vendor_id)");
        while (keepAdding){
            System.out.print("Item: ");
            String itemString = sc.nextLine();
            if (itemString.equals("-1")){
                break;
            }

            String[] itemDetails = itemString.split(",");
            Item item = new Item(itemDetails[0], itemDetails[1].trim(), Integer.parseInt(itemDetails[2].trim()), Double.parseDouble(itemDetails[3].trim()), itemDetails[4].trim());
            //IM.addItemToDataStructure(item);

        }

        System.out.println("Save to database: y or n");
        String option = sc.next();
        if (option.equals("y") | option.equals("Y")){
            IM.insertItemsToDb();
            
        }
        else{
            System.out.println("Data saving canceled");
        }
        
        
        
    }
}
