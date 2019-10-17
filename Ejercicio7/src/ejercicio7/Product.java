
package ejercicio7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Product {
    
    public String codigo;
    public String descripcion;
    public double prezo;
    
    public Product(){
        codigo=null;
        descripcion=null;
        prezo=0;
    }
    
    public Product(String codigo, String descripcion, double prezo){
        this.codigo=codigo;
        this.descripcion=descripcion;
        this.prezo=prezo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrezo() {
        return prezo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrezo(double prezo) {
        this.prezo = prezo;
    }
    
    public void guardarProducto() throws FileNotFoundException, IOException{
        
        FileOutputStream fichero = new FileOutputStream("produtos.txt",true);
        DataOutputStream dataOut = new DataOutputStream(fichero);
        
        dataOut.writeUTF(this.getCodigo()+","+this.getDescripcion()+",");
        dataOut.writeDouble(this.getPrezo());
        
        dataOut.close();
        fichero.close();
        
    }
    
    public static void verFichero() throws FileNotFoundException, IOException{
        
        FileInputStream fichero = new FileInputStream("produtos.txt");
        DataInputStream dataIn = new DataInputStream(fichero);
        
        while(dataIn.available()>0){
            System.out.println(dataIn.readUTF()+dataIn.readDouble());
        }  
        dataIn.close();
        fichero.close();
    }

    public static ArrayList<Product> gardarEnFichero() throws FileNotFoundException, IOException{
    
        FileInputStream fichero = new FileInputStream("produtos.txt");
        DataInputStream dataIn = new DataInputStream(fichero);
        ArrayList<Product> al = new ArrayList<Product>();
        
        while(dataIn.available()>0){
            String objeto = dataIn.readUTF()+dataIn.readDouble();
            String[] parts = objeto.split(",");
            double value = Double.parseDouble(parts[2]);
            Product poMetodo = new Product(parts[0],parts[1],value);
            al.add(poMetodo);
        }
        return al;
    }
}