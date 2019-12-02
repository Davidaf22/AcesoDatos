package examenadav1_davidalonsofernandez;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamenADAV1_DavidAlonsoFernandez {

    public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
        
        conexion.getConexion();
        File archivo = new File ("vendas.txt");
        FileWriter fr = new FileWriter (archivo);
        BufferedWriter br = new BufferedWriter(fr);
        ResultSet rv = conexion.buscarVendas();
        while (rv.next()) {
            System.out.println("Venda :"+rv.getInt("nv")+","+rv.getString("codp")+","+rv.getInt("cantv")+","+rv.getString("des"));
            String codigo = rv.getString("codp");
            ResultSet rs = conexion.buscarStock(codigo);
            String nombre = "";
            int cantidadStock = 0;
            while (rs.next()) {
                nombre = rs.getString("nomp");
                cantidadStock = rs.getInt("cants");
            }
            System.out.println("nome producto: "+nombre+" ,cantidad Stock: "+cantidadStock);
            int nuevaCantidad = cantidadStock-rv.getInt("cantv");
            System.out.println("Cantidad despois: "+nuevaCantidad);
            conexion.actualizarNumeroAnalisis(codigo, nuevaCantidad);
            
            ResultSet rp = conexion.buscarPrezos(codigo);
            int precio = 0;
            int descuento = 0;
            while(rp.next()){
                precio = rp.getInt("prezo");
                descuento = rp.getInt("de");
            }
            System.out.println("prezo : "+precio+" , descuento posible de : "+descuento);
            int precioFinal = 0;
            if (rv.getString("des").equals("s")) {
                System.out.println("Descuento aplicable");
                precioFinal = precio - descuento;
            }
            else{
                System.out.println("Descuento no aplicable");
                precioFinal = precio;
            }
            int total = precioFinal*rv.getInt("cantv");
            System.out.println("total : "+total);
            System.out.println();
            br.write(rv.getInt("nv")+","+nombre+","+rv.getInt("cantv")+","+total+"\n");
        }
        
        br.close();
        fr.close();
        conexion.closeConexion();
    }
    
}
