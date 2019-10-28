/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio16;

import ejercicio13.Product;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author oracle
 */
public class Ejercicio16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, XMLStreamException {
        // TODO code application logic here
        
       FileInputStream fis=new FileInputStream("/home/oracle/Desktop/NetBEans/Ejercicio13/ejercicio13.txt");
        ObjectInputStream ibs = new ObjectInputStream(fis);
        Product objeto2 = new Product();
        objeto2 = (Product)ibs.readObject();
        XMLOutputFactory a4 = XMLOutputFactory.newInstance();
        XMLStreamWriter a5 = a4.createXMLStreamWriter(new  FileWriter (new File ("Products.xml")));
        a5.writeStartDocument("1.0");
        a5.writeStartElement("Products");
        
        while(objeto2!=null){
            
            a5.writeStartElement("Producto");
            a5.writeStartElement("codigo");
            a5.writeCharacters(objeto2.getCodigo());
            a5.writeEndElement();
            a5.writeStartElement("descripcion");
            a5.writeCharacters(objeto2.getDescripcion());
            a5.writeEndElement();
            a5.writeStartElement("precio");
            String cadena = String.valueOf(objeto2.getPrezo());
            a5.writeCharacters(cadena);
            a5.writeEndElement();
            a5.writeEndElement();
            objeto2 = (Product)ibs.readObject();
        }
        a5.writeEndElement();

        ibs.close();
        fis.close();
        a5.close();
    }
}