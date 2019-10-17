package ejercicio8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Ejercicio8 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        /*String[] cod={"p1","p2","p3"};
        String[] desc ={"parafusos","cravos","tachas"};
        Double[] prezo ={3.0,4.0,5.0};

        FileOutputStream fichero1 = new FileOutputStream("arrays.txt",true);
        PrintWriter pw = new PrintWriter(fichero1);
        
        for (int x=0;x<cod.length;x++){
            pw.print(cod[x]);
            pw.print("\t");
            pw.print(desc[x]);
            pw.print("\t");
            pw.println(prezo[x]);  
        }
        
        pw.close();
        fichero1.close();*/
        
        FileInputStream fichero = new FileInputStream("arrays.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fichero));
 
	String line = null;
	while ((line = br.readLine()) != null) {
            String[] parts = line.split("\t");
            double value = Double.parseDouble(parts[2]);
            Product poMetodo = new Product(parts[0],parts[1],value);
            System.out.println(poMetodo.toString());
	}
	br.close();
        fichero.close();
        
        
    }  
}
