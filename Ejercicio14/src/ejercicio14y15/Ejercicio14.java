package ejercicio14y15;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

public class Ejercicio14 {

    public static void main(String[] args) throws IOException, XMLStreamException {
        
        XMLOutputFactory a4 = XMLOutputFactory.newInstance();
        XMLStreamWriter a5 = a4.createXMLStreamWriter(new  FileWriter (new File ("exercicio14.txt")));
        a5.writeStartDocument("1.0");
        a5.writeStartElement("autores");
        a5.writeStartElement("autor");
        a5.writeAttribute("codigo","a1");
        a5.writeStartElement("nome");
        a5.writeCharacters("Alexandre Dumas");
        a5.writeEndElement();
        a5.writeStartElement("titulo");
        a5.writeCharacters("El conde de montecristo");
        a5.writeEndElement();
        a5.writeStartElement("titulo");
        a5.writeCharacters("Los miserables");
        a5.writeEndElement();
        a5.writeEndElement();
        a5.writeStartElement("autor");
        a5.writeAttribute("codigo","a2");
        a5.writeStartElement("nome");
        a5.writeCharacters("Fiodor Dostoyevski");
        a5.writeEndElement();
        a5.writeStartElement("titulo");
        a5.writeCharacters("El idiota");
        a5.writeEndElement();
        a5.writeStartElement("titulo");
        a5.writeCharacters("Noches blancas");
        a5.writeEndElement();
        a5.writeEndElement();
        a5.writeEndElement();
        
        a5.close();
        
        XMLInputFactory pol = XMLInputFactory.newInstance();
        XMLStreamReader lon = pol.createXMLStreamReader(new  FileReader (new File ("exercicio14.txt")));
                
        do{
            System.out.println(lon.next());
            System.out.println(lon.getLocalName());
            System.out.println(lon.getAttributeValue(1));
            System.out.println(lon.getElementText());
        }while(lon.hasNext());
        
    }
    
}
