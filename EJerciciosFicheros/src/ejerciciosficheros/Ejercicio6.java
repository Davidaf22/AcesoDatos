/*
6)utilizando  os metodos axeitados amosar a ruta que corresponde  ao primeiro  directorio creado:
 */
package ejerciciosficheros;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author oracle
 */
public class Ejercicio6 {
    
    public static void mostrarPath () throws IOException {     
        
        File direcotrio = new File("/home/oracle/NetBeansProjects");

        System.out.println(direcotrio.getAbsolutePath());
        
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        Ejercicio6.mostrarPath();
    }
    
}
