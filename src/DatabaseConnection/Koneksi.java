package DatabaseConnection;
import java.sql.*;
import javax.swing.JOptionPane;


public class Koneksi {
    Connection conn;
    public Koneksi(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/penjualan_pplg1", "root", "");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "failed");
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
    
}