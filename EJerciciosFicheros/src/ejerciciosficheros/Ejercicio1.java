/*
 1) crear o directorio 'arquivosdir' na ruta '/home/oracle/NetBeansProjects/arquivos/' sempre e cando dito directorio non exista.
comprobar que a ruta foi creada ou existe mediante o comandos do sistema operativo
 */
package ejerciciosficheros;

import java.io.File;

/**
 *
 * @author oracle
 */
public class Ejercicio1 {
    
    public static void crearDirecotrio () {
        
        File direcotrio = new File("/home/oracle/NetBeansProjects/arquivos/arquivosdir");
        if (!direcotrio.exists()){
            
            direcotrio.mkdirs(); 
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Ejercicio1.crearDirecotrio();
    }
    
}
