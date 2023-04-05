import java.sql.*;

public class Database {

    private static Connection connection = null;

    public static Connection getConnection() {
        try{
            if (connection == null) {
                String url = "jdbc:mysql://localhost:3306/inventory_db";
                String username = "root";
                String password = "admin";
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Database connected");
            }
        }catch(Exception e){
            System.out.println("Database cannot connect");
            System.out.println(e);
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
}
