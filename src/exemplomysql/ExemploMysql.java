package exemplomysql;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ExemploMysql {

      private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://10.25.1.41/DBteste", user = "HPTNDevelopers", password = "projetopoo";
    public java.sql.Connection getConnection() throws ClassNotFoundException{
        try{
            Class.forName(driver);
            return DriverManager.getConnection(url,user,password);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}