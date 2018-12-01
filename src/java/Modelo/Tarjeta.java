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
public class Tarjeta {

    //Declaración de atributos
    private String numero;
    private int dv;
    private int mes_venc;
    private int ano_venc;

    //Contructor con y sin parametros
    public Tarjeta() {
    }

    public Tarjeta(String numero, int dv, int mes_venc, int ano_venc) {
        this.numero = numero;
        this.dv = dv;
        this.mes_venc = mes_venc;
        this.ano_venc = ano_venc;
    }

    //Metodos Accesadores y Mutadores
    public String getNumero() {
        return numero;
    }

    public int getDv() {
        return dv;
    }

    public int getMes_venc() {
        return mes_venc;
    }

    public int getAno_venc() {
        return ano_venc;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setDv(int dv) {
        this.dv = dv;
    }

    public void setMes_venc(int mes_venc) {
        this.mes_venc = mes_venc;
    }

    public void setAno_venc(int ano_venc) {
        this.ano_venc = ano_venc;
    }

    //ToString
    @Override
    public String toString() {
        return "Tarjeta{" + "numero=" + numero + ", dv=" + dv + ", mes_venc=" + mes_venc + ", ano_venc=" + ano_venc + '}';
    }
}
