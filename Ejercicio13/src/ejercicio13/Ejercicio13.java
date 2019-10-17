package ejercicio13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ejercicio13 {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        String[] cod={"p1","p2","p3"};
        String[] desc ={"parafusos","cravos ","tachas"};
        Double[] prezo ={3.0,4.0,5.0};
        
        FileOutputStream fos=new FileOutputStream("ejercicio13.txt");
        ObjectOutputStream obs = new ObjectOutputStream(fos);
        
        for(int x=0;x<cod.length;x++){
            Product objeto1 = new Product(cod[x],desc[x],prezo[x]);
            obs.writeObject(objeto1);
        }
        obs.writeObject(null);
        
        obs.close();
        fos.close();
        
        FileInputStream fis=new FileInputStream("ejercicio13.txt");
        ObjectInputStream ibs = new ObjectInputStream(fis);
        Product objeto2 = new Product();
        objeto2 = (Product)ibs.readObject();
        
        while(objeto2!=null){
            System.out.println(objeto2.toString());
            objeto2 = (Product)ibs.readObject();
        }
        
        ibs.close();
        fis.close();
    }
    
}
