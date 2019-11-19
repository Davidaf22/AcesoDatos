
package ejercicioexamen2;

import java.io.Serializable;


public class Platos2 implements Serializable{
    private String codigop;
    private String nomep;
    private int grasa;
    
    public Platos2(){
        this("","",0);
    }

    public Platos2(String codigo, String nome,int grasa){
		this.codigop = codigo;
		this.nomep = nome;
                this.grasa=grasa;
	}

	public void setCodigop(String code)
	{
		this.codigop = code;
	}

	public String getCodigop(){
		return codigop;
	}

	public void setNomep(String nome)
	{
		this.nomep = nome;
	}
       public String getNomep()
	{
		return nomep;
	}

        public int getGrasa() {
            return grasa;
        }

        public void setGrasa(int grasa) {
            this.grasa = grasa;
        }
        
        public String toString()
	{
		return "codigo plato : " + codigop + "\n" +
                       "nome plato  : " + nomep + "\n" +
                        "grasa plato  : " + grasa + "\n";
	}  
}