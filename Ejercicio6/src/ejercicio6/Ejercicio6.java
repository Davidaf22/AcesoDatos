
package ejercicio6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio6 {

    public static void writeFichero() throws FileNotFoundException, IOException {
        
        FileOutputStream fichero = new FileOutputStream("texto6.txt");
        DataOutputStream dataOut = new DataOutputStream(fichero);
        
        System.out.println("cadea a grabar : \"Está en casa\"");
        int j = dataOut.size();
        dataOut.writeUTF("Está en casa");
        System.out.println("writeUTF escribiu: Está en casa, numero de chars escritos: "+(dataOut.size()-j));
        dataOut.writeChars("Está en casa");
        System.out.println("writeChars escribiu: Está en casa, numero de chars escritos: "+(dataOut.size()-j));
        dataOut.writeUTF("Está en casa");
        System.out.println("writeUTF escribiu: Está en casa");
        System.out.println(dataOut.size());
        
        dataOut.close();
        fichero.close();
        
    }
    
    public static void readFichero() throws FileNotFoundException, IOException {
        
        FileInputStream fichero = new FileInputStream("texto6.txt");
        DataInputStream dataIn = new DataInputStream(fichero);
        
        System.out.println("lemos a primeira cadea mediante  readUTF: "+dataIn.readUTF());
        System.out.println(dataIn.available());
        String cadena="";
        while(dataIn.available()>15){
             cadena = cadena+dataIn.readChar();
         }
         System.out.println("lemos a segunda cadea mediante readChar (con bucle): "+cadena);
          System.out.println(dataIn.available());
         System.out.println("lemos a primeira cadea mediante  readUTF: "+dataIn.readUTF());
         
        dataIn.close();
        fichero.close();
    }
    
    
    
    public static void main(String[] args) throws IOException {
        Ejercicio6.writeFichero();
        Ejercicio6.readFichero();
        
    }
    
}
