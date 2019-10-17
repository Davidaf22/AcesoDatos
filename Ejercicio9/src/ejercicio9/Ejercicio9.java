
package ejercicio9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio9 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
   // ArrayList<Integer> caracteres = new ArrayList<Integer>();    
    FileReader fr=new FileReader("texto10.txt");
    FileWriter fw=new FileWriter("texto11.txt");
    int valor = fr.read();
    while(valor!=-1){
        fw.write(valor);
        System.out.println(valor);
        valor=fr.read();
    }
    
    fr.close();
    fw.close();
    }
    
}
