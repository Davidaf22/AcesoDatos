
package ejercicio3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author oracle
 */
public class Ejercicio3 {
    
    /*3.a*/
    public static void duplicarImagen() throws FileNotFoundException, IOException {

        File origen = new File("foto.jpg");
        File destino = new File("foto2.jpg");
        
        InputStream in = new FileInputStream(origen);
        OutputStream out = new FileOutputStream(destino,true);
        
        byte[] buf = new byte[1024];
        int len;
     
        while ((len = in.read(buf)) > 0) {
            out.write(buf,0,len);
        }
        
        in.close();
        out.close();
    
    }
    /*3.b
    No se ve repetido ni nada extraño.*/
    
    /*3.c*/
    public static void duplicarImagen2() throws FileNotFoundException, IOException {

        File origen = new File("foto.jpg");
        File destino = new File("foto2.jpg");
        
        InputStream in = new FileInputStream(origen);
        OutputStream out = new FileOutputStream(destino,true);
        
        BufferedInputStream bin=new BufferedInputStream(in);
        BufferedOutputStream bout=new BufferedOutputStream(out);

        
        byte[] buf = new byte[1024];
        int len;
     
        while ((len = bin.read(buf)) > 0) {
            bout.write(buf,0,len);
        }
        
        bin.close();
        bout.close();
        
        in.close();
        out.close();
    
    }
    
    
    
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Ejercicio3.duplicarImagen();
        Ejercicio3.duplicarImagen2();
    }
    
}
