package ejercicioexamen3;

public class Uva {
    
    String codigoA;
    int acidez;
    int grao;
    int tanitos;
    String tipoUva;
    int cantidade;
    String dni;
    
    public Uva(){}
    
    public Uva(String codigoA,int acidez, int grao, int tanitos,String tipoUva,int cantidade,String dni){
        this.codigoA=codigoA;
        this.acidez=acidez;
        this.grao=grao;
        this.tanitos=tanitos;
        this.tipoUva=tipoUva;
        this.cantidade=cantidade;
        this.dni=dni;
    }

    public String getCodigoA() {
        return codigoA;
    }

    public int getAcidez() {
        return acidez;
    }

    public int getGrao() {
        return grao;
    }

    public int getTanitos() {
        return tanitos;
    }

    public String getTipoUva() {
        return tipoUva;
    }

    public int getCantidade() {
        return cantidade;
    }

    public String getDni() {
        return dni;
    }

    public void setCodigoA(String codigoA) {
        this.codigoA = codigoA;
    }

    public void setAcidez(int acidez) {
        this.acidez = acidez;
    }

    public void setGrao(int grao) {
        this.grao = grao;
    }

    public void setTanitos(int tanitos) {
        this.tanitos = tanitos;
    }

    public void setTipoUva(String tipoUva) {
        this.tipoUva = tipoUva;
    }

    public void setCantidade(int cantidade) {
        this.cantidade = cantidade;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Uva{" + "codigoA=" + codigoA + ", acidez=" + acidez + ", grao=" + grao + ", tanitos=" + tanitos + ", tipoUva=" + tipoUva + ", cantidade=" + cantidade + ", dni=" + dni + '}';
    }
}
