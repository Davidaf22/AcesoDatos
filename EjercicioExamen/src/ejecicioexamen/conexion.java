package ejecicioexamen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


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
     
     public static int buscarComposicion(String cod) throws SQLException{

        Connection con = conexion;
        String consulta = "select * from composicion where codp=?";
        PreparedStatement stmt= con.prepareStatement(consulta);
        stmt.setString(1,cod);
        ResultSet rs = stmt.executeQuery();
       
        int grasa = 0;
        int grasaTemp = 0;
         while (rs.next()) {
            String codigo = rs.getString("codc");
            int peso = rs.getInt("peso");
            int porcentaje = buscarComponentes(codigo);
            double porcentajeTemp = (double)porcentaje/100;
            grasaTemp =(int)((int) peso * porcentajeTemp);           
            grasa = grasa + grasaTemp;
              }
         return grasa;
     }
     
     public static int buscarComponentes(String cod) throws SQLException{

        Connection con = conexion;
        String consulta = "select * from componentes where codc=?";
        PreparedStatement stmt= con.prepareStatement(consulta);
        stmt.setString(1,cod);
        ResultSet rs = stmt.executeQuery();
        
        int grasa = 0;
         while (rs.next()) {
            grasa = rs.getInt("graxa");
              }
         return grasa;
     }
     
      public static int buscarComponentes2(String cod) throws SQLException{

        Connection con = conexion;
        String consulta = "select * from componentes where codc=?";
        PreparedStatement stmt= con.prepareStatement(consulta);
        stmt.setString(1,cod);
        ResultSet rs = stmt.executeQuery();
        
        int grasa = 0;
         while (rs.next()) {
            grasa = rs.getInt("graxa");
              }
         return grasa;
     }
     
     public static void isertarXerado(String codigo,String nombre,String texto, int total) throws SQLException{
         Connection con = conexion;
         
         PreparedStatement stmt = con.prepareStatement("INSERT INTO xerado VALUES (?,?,?,?)");
        
        stmt.setString(1,codigo);
        stmt.setString(2,nombre);
        stmt.setString(3,texto);
        stmt.setInt(4,total);
        
        stmt.executeUpdate();
        
        System.out.println("Xerado insertado");
     }
     
     public static ResultSet buscarNombreUva(String tipo) throws SQLException{
         
        Connection con = conexion;
         
        String consulta = "select * from uvas where tipo=?";
        PreparedStatement stmt= con.prepareStatement(consulta);
        stmt.setString(1,tipo);
        ResultSet rs = stmt.executeQuery();
        return rs;   
     }
     
     
     public static ResultSet buscarDni(String dni) throws SQLException{
     
        Connection con = conexion;
         
        String consulta = "select * from clientes where dni=?";
        PreparedStatement stmt= con.prepareStatement(consulta);
        stmt.setString(1,dni);
        ResultSet rs = stmt.executeQuery();
        return rs;   
     }
     
      public static void actualizarNumeroAnalisis(String dni) throws SQLException{    
          
        Connection con = conexion;
         
        String consulta = "select * from clientes where dni=?";
        PreparedStatement stmt= con.prepareStatement(consulta);
        stmt.setString(1,dni);
        ResultSet rs = stmt.executeQuery();
        
        int numAnalisis=0;
        while (rs.next()) {
            numAnalisis=rs.getInt("numerodeanalisis");         
        }
        
        numAnalisis++;
         
        PreparedStatement stmtr = con.prepareStatement("update clientes set numerodeanalisis=? where dni=?");
        
        stmtr.setInt(1,numAnalisis);
        stmtr.setString(2,dni);
        
        stmtr.executeUpdate();
        
        System.out.println("Numero de Analisis actualizado");
     }
     
     
}

   