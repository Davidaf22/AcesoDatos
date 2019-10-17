package ejercicio12;

import java.io.Serializable;

public class mclase implements Serializable {
    public String nome;
    //public int numero1;
    public transient int numero1;
    public double numero2;
    
    public mclase(){}
    public mclase (String nome, int numero1, double numero2){
        this.nome=nome;
        this.numero1=numero1;
        this.numero2=numero2;
    }

    @Override
    public String toString() {
        return "mclase{" + "nome=" + nome + ", numero1=" + numero1 + ", numero2=" + numero2 + '}';
    }

    public String getNome() {
        return nome;
    }

    public int getNumero1() {
        return numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }
}
