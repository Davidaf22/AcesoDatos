package ejercicio7;

import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio7 {
    
    public static void main(String[] args) throws IOException {
        
        Product po1 = new Product("cod1", "parafusos", 3);
        Product po2 = new Product("cod2", "cravos", 4);
        Product po3 = new Product();
        
        po1.guardarProducto();
        po2.guardarProducto();
        
        //Product.verFichero();
        
        ArrayList<Product> al = new ArrayList<Product>();
        al = Product.gardarEnFichero();
        
        for(int x=0;x<al.size();x++){
            po3=al.get(x);
            System.out.println(po3.getCodigo()+","+po3.getDescripcion()+","+po3.getPrezo());
        }
        
        
    }    
    
}
