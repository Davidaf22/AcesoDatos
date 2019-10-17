/*
7)utilizando  os metodos axeitados amosar a seguinte informacion sobre o primeiro obxecto arquivo creado:

	 nome
	 ruta
	 si e posible ou non escribir nel
	 si e posible ou non ler del
	 a sua lonxitude en bytes (para isto escribir no arquivo mediante calquerea editor de texto  ,  o texto
 */
package ejerciciosficheros;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author oracle
 */
public class Ejercicio7y8y9 {
    
    public static void infoArchivo() throws IOException {
        
        File archivo;
        archivo = new File("/home/oracle/NetBeansProjects/arquivos/arquivosdir/Products1.txt");
       
        System.out.println("Nombre:"+"Products1.txt");
        System.out.println("PATH:"+archivo.getAbsolutePath());
        System.out.println("Permisos de lectura:"+ archivo.canRead());
        System.out.println("Permisos de escritura:"+ archivo.canWrite());
        System.out.println("LOngitud en bytes:"+ archivo.length());
    }
    
    public static void forzarLectura() throws IOException {
        File archivo;
        archivo = new File("/home/oracle/NetBeansProjects/arquivos/arquivosdir/Products1.txt");
        
        archivo.setReadOnly();
    }
    
    public static void forzarEscritura() throws IOException {
        File archivo;
        archivo = new File("/home/oracle/NetBeansProjects/arquivos/arquivosdir/Products1.txt");
        
        archivo.setWritable(true);
    }
    
     public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        Ejercicio7y8y9.infoArchivo();
        Ejercicio7y8y9.forzarLectura();
        Ejercicio7y8y9.forzarEscritura();
    }
    
    
}
