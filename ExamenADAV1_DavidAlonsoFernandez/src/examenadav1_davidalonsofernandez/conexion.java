package examenadav1_davidalonsofernandez;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class conexion {
    
     public static Connection conexion=null;
     
     public static Connection getConexion() throws SQLException{
        String usuario = "hr";
        String password = "hr";
        String host = "localhost"; 
        String puerto = "1521";
        String sid = "orcl";
        String ulrjdbc = "jdbc:oracle:thin:" + usuario + "/" + password + "@" + host + ":" + puerto + ":" + sid;  
           
            conexion = DriverManager.getConnection(ulrjdbc);
            return conexion;
        }
     
     public static void closeConexion() throws SQLException {
         
        conexion.close();
        
      }
     
     public static ResultSet buscarVendas() throws SQLException{

        Connection con = conexion;
        String consulta = "select * from vendas";
        PreparedStatement stmt= con.prepareStatement(consulta);
        ResultSet rs = stmt.executeQuery();
        
        return rs;
     }
     
     public static ResultSet buscarStock (String cod) throws SQLException{

        Connection con = conexion;
        String consulta = "select * from stock where codp=?";
        PreparedStatement stmt= con.prepareStatement(consulta);
        stmt.setString(1,cod);
        ResultSet rs = stmt.executeQuery();
        
        return rs;
     }
     
     public static ResultSet buscarPrezos (String cod) throws SQLException{

        Connection con = conexion;
        String consulta = "select * from prezos where codp=?";
        PreparedStatement stmt= con.prepareStatement(consulta);
        stmt.setString(1,cod);
        ResultSet rs = stmt.executeQuery();
        
        return rs;
     }
     
    public static void actualizarNumeroAnalisis(String codp,int cantidad) throws SQLException{    
          
        Connection con = conexion;
         
        PreparedStatement stmtr = con.prepareStatement("update stock set cants=? where codp=?");
        
        stmtr.setInt(1,cantidad);
        stmtr.setString(2,codp);
        
        stmtr.executeUpdate();
        
        System.out.println("Numero de Stock Actualizado");
     }
     
     

    
}
