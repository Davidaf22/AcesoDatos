/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio5 {

    public static void writeFichero() throws FileNotFoundException, IOException {
        
        FileOutputStream fichero = new FileOutputStream("texto5.txt");
        DataOutputStream dataOut = new DataOutputStream(fichero);
        
         System.out.println("A cadena a escribir é: o tempo está xélido");
         System.out.println("a lonxitude desta cadea en carateres e: 19 ero cando se grabe co metodo writeChars vai a ocupar 38 bytes  posto que se usan 2 bytes por cada caracter  sempre");

        
        int j=0;
        for(int x=0;x<2;x++){
            
        dataOut.writeChars("o tempo está xélido");
        j = dataOut.size()-j;
        System.out.println("Caracteres escritos "+j);
        
        }
        
        dataOut.close();
        System.out.println("bytes totais escritos: "+dataOut.size());
        
   
    }
    
    public static void readFichero() throws FileNotFoundException, IOException {
        
        FileInputStream fichero = new FileInputStream("texto5.txt");
        DataInputStream dataIn = new DataInputStream(fichero);
        

        while(dataIn.available()>0){
            int y = 1;
            String cadena="";
            while(y<20){
                cadena = cadena+dataIn.readChar();
                y++;
            }
            System.out.println("lemos a primeira cadea:"+cadena);
            System.out.println("o numero de bytes lidos e :"+(y-1)*2);
            System.out.println("Quedan por leer "+dataIn.available()+" bytes"); 
        }
        
       dataIn.close();
       fichero.close();
        
    }
    
    public static void main(String[] args) throws IOException {
        
        Ejercicio5.writeFichero();
        Ejercicio5.readFichero();
    }
    
}
