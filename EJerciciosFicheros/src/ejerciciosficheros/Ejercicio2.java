/*
 2) crear  o arquivo Products1.txt no directorio mencionado anteriormente (arquivosdir) sempre e cando dito arquivo non exista. 
comprobar que o arquivo foi creado ou existe mediante comandos do sistema operativo
 */
package ejerciciosficheros;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author oracle
 */
public class Ejercicio2 {
    
    public static void crearArchivo () throws IOException {
        
        File archivo;
        archivo = new File("/home/oracle/NetBeansProjects/arquivos/arquivosdir/Products1.txt");
        if (!archivo.exists()){
            archivo.createNewFile(); 
        }
        archivo.createNewFile();
    }
     public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        Ejercicio2.crearArchivo();
    }
    
    
}
