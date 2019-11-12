/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio17;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import ejercicio13.Product;

public class Ejercicio17 {

    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {

        XMLInputFactory pol = XMLInputFactory.newInstance();
        XMLStreamReader lon = pol.createXMLStreamReader(new  FileReader (new File ("Products.xml")));
        ArrayList<Product> proctosArray = new ArrayList<Product>();
        int contador = -1;
        
                while(lon.hasNext()){
            if(lon.getEventType()==XMLStreamConstants.START_ELEMENT){
                if("codigo".equals(lon.getLocalName())){
                    contador++;
                   Product producto = new Product();
                   String codigo = lon.getElementText();
                   producto.setCodigo(codigo);
                   proctosArray.add(producto);
                }
                else if ("descripcion".equals(lon.getLocalName())) {
                    String descripcion = lon.getElementText();
                    proctosArray.get(contador).setDescripcion(descripcion);
                }
                else if ("precio".equals(lon.getLocalName())) {
                    Double precio = Double.parseDouble(lon.getElementText());
                    proctosArray.get(contador).setPrezo(precio);
                }
            }
            lon.next();
        }
     lon.close();
     
     for (int x=0;x<proctosArray.size();x++){
         System.out.println(proctosArray.get(x).toString());
     }    
    }
    
}
