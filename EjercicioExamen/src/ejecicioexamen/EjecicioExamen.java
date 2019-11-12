
package ejecicioexamen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.SQLException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class EjecicioExamen {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, XMLStreamException {
        
        XMLOutputFactory a4 = XMLOutputFactory.newInstance();
        XMLStreamWriter a5 = a4.createXMLStreamWriter(new  FileWriter (new File ("Platos.xml")));
        a5.writeStartDocument("1.0");
        a5.writeStartElement("PLatos");
 
        conexion.getConexion();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("platos2"));
       
        // Se lee el primer objeto
        Platos aux = (Platos)ois.readObject();
        // Mientras haya objetos
        while (aux!=null){
        if (aux instanceof Platos)
        a5.writeStartElement("Plato");
        System.out.println(aux.toString());
        String cod = aux.getCodigop();
        int grasa = conexion.buscarComposicion(cod);
        System.out.println(grasa);
        String grasaString = Integer.toString(grasa);
        a5.writeAttribute("Codigop", aux.getCodigop());
        a5.writeStartElement("nomep");
        a5.writeCharacters(aux.getNomep());
        a5.writeEndElement();
        a5.writeStartElement("graxatotal");
        a5.writeCharacters(grasaString);
        a5.writeEndElement();
        a5.writeEndElement();
        aux =(Platos)ois.readObject();
        }
        a5.writeEndElement();
        ois.close();
        conexion.closeConexion();
        a5.close();
        
        
        
        
        
    } 
}
