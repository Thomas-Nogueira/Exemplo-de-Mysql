package exemplomysql;

import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.DriverManager.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
 
public static void main(String[] args){
        
        Connection conn;
        PreparedStatement ps;
        Statement stmt;
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://10.25.1.41:3306/dbteste?user=root&password=password&useSSl=false");
            
            stmt = conn.createStatement();
            
           ResultSet rs = stmt.executeQuery("SELECT * FROM dbteste.aluno");
           
           while(rs.next()){
               int id = rs.getInt("idaluno");
               String nome = rs.getString("nome");
               String endereco = rs.getString("endereco");
               
               System.out.println("ID: "+ id + " ---- Nome: " + nome + " ---- Endereco: " + endereco);
           }
            
            String inserir = "INSERT INTO alunos "
                    + "(idaluno, nome, endereco)"
                    + " (?,?,?)";
            ps = conn.prepareStatement(inserir);
            ps.setInt(1, 123);
            ps.setString(2, "Thomas");
            ps.setString(3, "Na minha casa");
            
            int result = ps.executeUpdate();
            
            String sql = "UPDATE aluno SET nome = 'Felipe Massa' WHERE idaluno = 1";
            int update = stmt.executeUpdate(sql);
            System.out.println(update);
            
            String sqlDeletar = "DELETE FROM aluno WHERE idaluno = ?";
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
    
    

