package ejercicio19;

import ejercicio13.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio19 {
    
    public static String driver = "jdbc:oracle:thin:";
    public static String host = "localhost.localdomain"; // tambien puede ser una ip como "192.168.1.14"
    public static String porto = "1521";
    public static String sid = "orcl";
    public static  String usuario = "hr";


    public static String password = "hr";
    public String url = driver + usuario + "/" + password + "@" + host + ":" + porto + ":" + sid;
    public Connection conn;
    
    
    public Ejercicio19(){}
    
    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }

    public void conexion (){
        Connection con = null;
        try {
            con = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(Ejercicio19.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Conexion abierta");
        this.setConn(con);
    }
    
    public ResultSet listaProdutos() throws SQLException{
        
        String consulta = "select produtos.* from produtos";
        PreparedStatement stmt= conn.prepareStatement (consulta, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery();
        System.out.println("Consulta realizada");
       // stmt.close();
        return rs;
    }
    
    public void listadoCompleto(ResultSet rs) throws SQLException{
        
        while (rs.next()) {
            String codigo = rs.getString("codigo");
            String descripcion = rs.getString("descripcion");
            int precio = rs.getInt("prezo");
            Product producto = new Product(codigo,descripcion,precio);
             System.out.println(producto.toString());
         }  
        
        
    }
    
    public void actualizarListado(ResultSet rs,String codigo, int nuevoPrecio) throws SQLException{
        
        
         while (rs.next()) {             
             if (rs.getString("codigo").equals(codigo)){
                  rs.updateInt("prezo", nuevoPrecio);
                  System.out.println("Actualizacion realizada");
                  rs.updateRow();
             }
         } 
         
    }

    public static void main(String[] args) throws SQLException {
        
        Ejercicio19 bbdd = new Ejercicio19();
        bbdd.conexion();
        ResultSet rs = bbdd.listaProdutos();
        //bbdd.actualizarListado(rs, "p2", 30);
        bbdd.listadoCompleto(rs);
        bbdd.getConn().close();
    }
    
}
