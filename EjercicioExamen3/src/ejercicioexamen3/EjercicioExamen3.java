package ejercicioexamen3;

import ejecicioexamen.conexion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EjercicioExamen3 {

    public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
        
        conexion.getConexion();
        String linea;
        File archivo = new File ("analisis.txt");
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);
        while((linea=br.readLine())!=null){
            String[] parts = linea.split(",");
            Uva uva = new Uva(parts[0],Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),Integer.parseInt(parts[3]),parts[4],Integer.parseInt(parts[5]),parts[6]);
            ResultSet rs = conexion.buscarNombreUva(uva.getTipoUva());
            String nombre=null;
            String mensaje =null;
            int acidMax=0;
            int acidMin=0;
            while (rs.next()) {
                nombre =rs.getString("nomeu");
                acidMax=rs.getInt("acidezmax");
                acidMin=rs.getInt("acidezmin");          
            }
            if (uva.getAcidez()>=acidMin && uva.getAcidez()<=acidMax){
                mensaje = "Acidez correcta";
            }
            else if(uva.getAcidez()<acidMin){
                mensaje="Subir Acidez";
            }
            else if(uva.getAcidez()>acidMax){
                mensaje="Bajar Acidez";
            }
            
            int total = uva.getCantidade()*15;
            
            conexion.actualizarNumeroAnalisis(uva.getDni());
            conexion.isertarXerado(uva.getCodigoA(), nombre, mensaje, total); 
           
        }       
    } 
}
