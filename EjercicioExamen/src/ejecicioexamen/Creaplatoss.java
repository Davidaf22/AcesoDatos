package ejecicioexamen;

import java.io.*;
public class Creaplatoss {

    public static void main(String args[]) {
   /* // Object serialization
     String[] codes={"p1","p2"};
     String[] descricion ={"platocarnico1","platocarnico2 "};

    try {
    Platos pl=null;
    
    FileOutputStream fos = new FileOutputStream("platos2");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    
     
        
        for (int i=0; i < codes.length;i++)
        {
        pl = new Platos();  
        pl.setCodigop(codes[i]);
        pl.setNomep(descricion[i]);
        System.out.println("object: " + pl);
        oos.writeObject(pl);
        oos.flush();

       }   
        System.out.println("yaya");
    oos.writeObject(null);
    oos.close();
    fos.close();
    }
    catch(Exception e) {
    System.out.println("Exception during serialization: " + e);
    }
    System.out.println("LE PLATOSS");
    try {
    Platos object2;
    FileInputStream fis = new FileInputStream("platos2");
    ObjectInputStream ois = new ObjectInputStream(fis);
    
    
    while ((object2 = (Platos)ois.readObject()) != null) {
        System.out.println("object2: " + object2);
    }
    ois.close();
    fis.close();
    }
    catch(Exception e) {
    System.out.println("Exception during deserialization: " +
    e);
    System.exit(0);
    }*/
    }
    
}