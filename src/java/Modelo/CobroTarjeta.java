/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Ricardo Pasten
 */
public class CobroTarjeta {  
    //Atributos de la clase
    private String cobroNumeroTarjeta;
    private int monto;
    
    //Constructores con y sin parametros 

    public CobroTarjeta() {
    }

    public CobroTarjeta(String cobroNumeroTarjeta, int monto) {
        this.cobroNumeroTarjeta = cobroNumeroTarjeta;
        this.monto = monto;
    }
    
    //Metodos Accesadores y Mutadores

    public String getCobroNumeroTarjeta() {
        return cobroNumeroTarjeta;
    }

    public int getMonto() {
        return monto;
    }

    public void setCobroNumeroTarjeta(String cobroNumeroTarjeta) {
        this.cobroNumeroTarjeta = cobroNumeroTarjeta;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
     //ToString
    @Override
    public String toString() {
        return "CobroTarjeta{" + "cobroNumeroTarjeta=" + cobroNumeroTarjeta + ", monto=" + monto + '}';
    }
}
