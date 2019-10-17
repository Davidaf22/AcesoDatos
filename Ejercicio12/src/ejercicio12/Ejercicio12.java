package ejercicio12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ejercicio12 {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        mclase objeto1 = new mclase("ola",-7, 2.7E10);
        
        FileOutputStream fos=new FileOutputStream("serial.txt");
        ObjectOutputStream obs = new ObjectOutputStream(fos);
        obs.writeObject(objeto1);
        
        obs.close();
        fos.close();
        
        mclase objeto2 = new mclase();
        FileInputStream fis=new FileInputStream("serial.txt");
        ObjectInputStream ibs = new ObjectInputStream(fis);
        objeto2=(mclase)ibs.readObject();
        System.out.println(objeto2.toString());
        
        ibs.close();
        fis.close();
    }
    
}
