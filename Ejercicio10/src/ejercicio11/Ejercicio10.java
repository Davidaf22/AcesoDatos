package ejercicio11;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import static javax.swing.Spring.width;

public class Ejercicio10 {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        RandomAccessFile raf = new RandomAccessFile("ejercicio11.txt", "rw");
        String[] cod={"p1","p2","p3"};
        String[] desc ={"parafusos","cravos","tachas"};
        Integer[] prezo ={3,4,5};        
        
       
        for (int x=0;x<cod.length;x++){
            Product po1 = new Product(cod[x],desc[x],prezo[x]);
            String cod1 = String.format("%-" + 3 + "s", po1.getCodigo());
            raf.writeChars(cod1);
            String desc1 = String.format("%-" + 10 + "s", po1.getDescripcion());
            raf.writeChars(desc1);
            raf.writeInt((int) po1.getPrezo());
        }
        
        raf.close();
        
        RandomAccessFile rad = new RandomAccessFile("ejercicio11.txt", "r");        
        
        int h = 0;
        int j = 26;
        for (int i =0;i<3;i++) {
            rad.seek(h);
            byte[] bytes = new byte[30];
            rad.read(bytes);
            String palabras = new String(bytes);
            String[] parts = palabras.split(" ");
            System.out.println(parts[0]);
            System.out.println(parts[1]);
            //System.out.println(new String(bytes));
            rad.seek(j);
            System.out.println(rad.readInt());
            System.out.println(" ");
            h=h+30;
            j=j+30;
        }
        rad.close();
        
    }
    
}
