/*

2) exercicio copybytestexto
 * Neste exercicio trataremos os fluxos de Bytes (binary streams)

Por cada modificacion que se pide deixa comentada a linea como estaba antes da modificacion para deixar constancia de todas as modificacions desenvolvidas no exercicio.
A clase   FileInputStream permite ler bytes dende un ficheiro do sistema .
Para elo imos utilizar o metodo read() de dita clase que leera byte a byte . 
Cando se pase ao fin do ficheiro devoltara un valor -1 
( polo tanto deberedes preguntar por este valor para detectar o fin do ficheiro,  
e non facer mais lecturas que darian un erro) 


FileOutputStream e unha clase que permite facer xusto o contrario, 
escribir bytes nun ficheiro do sistema.
Para elo imos utilizar o metodo write() de dita clase.
 
nota: a clase FileOutputStream acepta nun dos seus  contructores un segundo parametro tipo boolean que si e “true” indica que  o ficheiro se abre en modo append (engadir) , e dicir que se usamos este parametro co valor “true”  cando voltemos escribir neste ficheiro o seu contido non se sobreescribe 

nota IMPORTANTE : lembrar pechar o obxecto OutputStream co seu metodo close() 
deste xeito os datos que poidan quedar no buffer son trasladados ao ficheiro destino. 

1)crea a man cun editor de texto simple 
(un editor de texto plano de Centos e “gedit” por exemplo) 
un pequeno ficheiro de texto chamado texto1.txt con tres lineas :
ola
adeus
cecais

2_1)Desenvolve unha pequena aplicacion que usando somente estas duas clases 
e os metodos indicados  copie  byte a byte o contido do  ficheiro de texto 
chamado texto1.txt noutro ficheiro chamado texto2.txt

2_2) Fai a modifica necesaria na aplicacion anterior para que se engada de novo o 
texto do ficheiro texto1.txt ao ficheiro texto2.txt
 */
package ejercicio2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

/**
 *
 * @author oracle
 */
public class Ejercicio2 {
    
    public static void duplicarFichero() throws FileNotFoundException, IOException {

        File origen = new File("texto1.txt");
        File destino = new File("texto2.txt");
        
        InputStream in = new FileInputStream(origen);
        OutputStream out = new FileOutputStream(destino,true);
        
        byte[] buf = new byte[1024];
        int len;
     
        while ((len = in.read(buf)) > 0) {
            out.write(buf,0,len);
        }
        
        in.close();
        out.close();
    
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        
        Ejercicio2.duplicarFichero();
        
    }
    
}
