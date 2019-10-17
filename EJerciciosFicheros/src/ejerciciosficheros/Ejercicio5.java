/*
5)amosar arquivos e subdirectorios do directorio creado '/home/oracle/NetBeansProjects/arquivos/arquivosdir/' utilizar para elo o metodo da clase File axeitado : debería verse o seguinte resultado:
 */
package ejerciciosficheros;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author oracle
 */
public class Ejercicio5 {
    
    public static void mostrarDirFile () throws IOException {     
        
        File direcotrio = new File("/home/oracle/NetBeansProjects/arquivos/arquivosdir");
        
        String[] ficheros = direcotrio.list();
        
        for(int x=0;x<ficheros.length;x++){
            
            System.out.println(ficheros[x]);
            
        }
        
        
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        Ejercicio5.mostrarDirFile();
    }
    
}
