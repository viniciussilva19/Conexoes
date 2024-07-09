package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    private static String USERNAME = "root";
    private static String PASSWORD = "090733vi";
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/exemplobd";
    public Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        catch(ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}
  
