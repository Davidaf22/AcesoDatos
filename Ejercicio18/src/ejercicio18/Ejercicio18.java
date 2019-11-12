
package ejercicio18;

import ejercicio13.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio18 {
    
    public static String driver = "jdbc:oracle:thin:";
    public static String host = "localhost.localdomain"; // tambien puede ser una ip como "192.168.1.14"
    public static String porto = "1521";
    public static String sid = "orcl";
    public static  String usuario = "hr";
    public static String password = "hr";
    public String url = driver + usuario + "/" + password + "@" + host + ":" + porto + ":" + sid;
    
    public Ejercicio18(){}
    
    public Connection conexion (){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(Ejercicio18.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    } 
    
    public void insireProduto(Product producto) throws SQLException{
       Connection con = this.conexion();
        PreparedStatement stmt = con.prepareStatement("INSERT INTO produtos VALUES (?,?,?)");
        
        String codigo = producto.getCodigo();
        String descripcion = producto.getDescripcion();
        int precio =(int) producto.getPrezo();
        
        stmt.setString(1,codigo);
        stmt.setString(2,descripcion);
        stmt.setInt(3,precio);
        
        stmt.executeUpdate();
        
        System.out.println("Producto insertado");
        
        con.close();
        
    }
    
    public void listaProdutos() throws SQLException{
        
        Connection con = this.conexion();
        String consulta = "select * from produtos";
        PreparedStatement stmt= con.prepareStatement(consulta);
        ResultSet rs = stmt.executeQuery();
        
         while (rs.next()) {
            String codigo = rs.getString("codigo");
            String descripcion = rs.getString("descripcion");
            int precio = rs.getInt("prezo");
            Product producto = new Product(codigo,descripcion,precio);
             System.out.println(producto.toString());

         }
    }
    
    public void actualizaPre(int precio, String codigo) throws SQLException{
        
        Connection con = this.conexion();
        String consulta = "update produtos set prezo = ? where codigo=?";
        PreparedStatement stmt= con.prepareStatement(consulta);
        
        stmt.setString(2,codigo);
        stmt.setInt(1,precio);
        
         stmt.executeUpdate();
         
         con.close();
         
         System.out.println("Producto actualizado");
        
    }
    
    public void borrarfila (String codigo) throws SQLException{
        
        Connection con = this.conexion();
        String consulta = "delete from produtos where codigo=?";
        PreparedStatement stmt= con.prepareStatement(consulta);
        
        stmt.setString(1,codigo);
        
         stmt.executeUpdate();
         
         con.close();
         
         System.out.println("Producto borrado");
        
    }
    
    public void amosarFila(String codigoB) throws SQLException{
        
        Connection con = this.conexion();
        String consulta = "select * from produtos where codigo=?";
        PreparedStatement stmt= con.prepareStatement(consulta);
        stmt.setString(1,codigoB);
        ResultSet rs = stmt.executeQuery();
        
         while (rs.next()) {
            String codigo = rs.getString("codigo");
            String descripcion = rs.getString("descripcion");
            int precio = rs.getInt("prezo");
            Product producto = new Product(codigo,descripcion,precio);
             System.out.println(producto.toString());

         }
    }
    
    
    public static void main(String[] args) throws SQLException {
        
        Product producto = new Product ("p1","parafusos",3.0);
        Product producto2 = new Product ("p2","cravos",4.0);
        Product producto3 = new Product ("p3","tachas",6.0);
        Ejercicio18 bbdd = new Ejercicio18();
        //bbdd.insireProduto(producto);
        //bbdd.insireProduto(producto2);
        //bbdd.insireProduto(producto3);
        //bbdd.listaProdutos();
        //bbdd.actualizaPre(8,"p1");
        //bbdd.borrarfila("p1");
        //bbdd.amosarFila("p3");
        
    }
    
}
