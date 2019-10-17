/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author oracle
 */
public class Ejercicio4 {

    public static void writeFichero() throws FileNotFoundException, IOException {
        
        FileOutputStream fichero = new FileOutputStream("texto4.txt");
        DataOutputStream dataOut = new DataOutputStream(fichero);
        
        
        int j=0;
        for(int x=0;x<2;x++){
            
        dataOut.writeUTF("o tempo está xélido");
        j = dataOut.size()-j;
        System.out.println("writeUTF escribiu: "+j);
        
        }
        
        dataOut.close();
        System.out.println("bytes totais escritos: "+dataOut.size());
        
   
    }
    
    public static void readFichero() throws FileNotFoundException, IOException {
        
        FileInputStream fichero = new FileInputStream("texto4.txt");
        DataInputStream dataIn = new DataInputStream(fichero);
        
       // FileOutputStream ficheroOut = new FileOutputStream("texto3.txt");
        //DataOutputStream dataOut = new DataOutputStream(ficheroOut);
        

        while(dataIn.available()>0){
            System.out.println("lemos cadea en UTF: "+dataIn.readUTF());
            if(dataIn.available()>0){
                System.out.println("Quedan por leer "+dataIn.available()+"bytes"); 
            }
        }
        
       dataIn.close();
        
    }
    
    public static void main(String[] args) throws IOException {

        Ejercicio4.writeFichero();
        Ejercicio4.readFichero();
    }
    
}
