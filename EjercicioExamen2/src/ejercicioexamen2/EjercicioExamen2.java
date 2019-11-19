package ejercicioexamen2;

import ejecicioexamen.Platos;
import ejecicioexamen.conexion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class EjercicioExamen2 {
    
    /*public ArrayList<Platos2> leerTXT () throws FileNotFoundException, IOException{
        
        File archivo = new File ("composicion.txt");
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<Platos2> array = new ArrayList<Platos2>();
 
         String linea;
        while((linea=br.readLine())!=null){   
            String[] parts = linea.split("#");
        }
    
    return array;
    }*/
  
    public static void main(String[] args) throws XMLStreamException, FileNotFoundException, SQLException, IOException {
        
        conexion.getConexion();
        XMLInputFactory pol = XMLInputFactory.newInstance();
        XMLStreamReader lon = pol.createXMLStreamReader(new  FileReader (new File ("platos.xml")));
        
        
        
        FileOutputStream fos = new FileOutputStream("platosSerializable");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Platos2 platillo = null;
        
        while(lon.hasNext()){
            if(lon.getEventType()==XMLStreamConstants.START_ELEMENT){
                if("Plato".equals(lon.getLocalName())){
                    String codigo = lon.getAttributeValue(0);
                    platillo = new Platos2();
                    String linea;
                    int grasa=0;
                    File archivo = new File ("composicion.txt");
                    FileReader fr = new FileReader (archivo);
                    BufferedReader br = new BufferedReader(fr);
                    while((linea=br.readLine())!=null){   
                        String[] parts = linea.split("#");
                        if(parts[0].equals(codigo)){
                            int peso = Integer.parseInt(parts[2]);
                            String codCom = parts[1];
                            int porcentaje = conexion.buscarComponentes2(codCom);
                            double porcentajeTemp = (double)porcentaje/100;
                            int grasaTemp =(int)((int) peso * porcentajeTemp);
                            grasa = grasa + grasaTemp; 
                        }
                    }
                    platillo.setCodigop(codigo);
                    platillo.setGrasa(grasa);
                }
                else if ("nomep".equals(lon.getLocalName())) {
                    String nombre = lon.getElementText();
                    platillo.setNomep(nombre);
                    oos.writeObject(platillo);
                    oos.flush(); 
                }
            }
            lon.next();
        }   
        
        lon.close();
        conexion.closeConexion();
        oos.close();
        fos.close();

        System.out.println("LE PLATOSS");
        try {
        Platos2 object2;
        FileInputStream fis = new FileInputStream("platosSerializable");
        ObjectInputStream ois = new ObjectInputStream(fis);
    
        while ((object2 = (Platos2)ois.readObject()) != null) {
            System.out.println("codigo: "+object2.getCodigop());
            System.out.println("nombre: "+object2.getNomep());
            System.out.println("grasa: "+object2.getGrasa());
        }
        ois.close();
        fis.close();
        }
        catch(Exception e) {
        System.out.println("Exception during deserialization: " + e);
        System.exit(0);
        }     
    }    
}
