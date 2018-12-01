/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Tarjeta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Ricardo Pasten
 */
public class TarjetaDAO {

    Conexion con;

    public TarjetaDAO() {
        con = new Conexion();
    }

    public boolean validarTarjeta(String numero, int dv, int mes_venc, int ano_venc) {
        OracleCallableStatement ocs = null;
        Connection en = con.conectar().getCnn();
        ResultSet rs = null;
        ArrayList<Tarjeta> listaTarjetas = new ArrayList<Tarjeta>();
        try {
            ocs = (OracleCallableStatement) en.prepareCall("{call TARJETA_PKG.SP_VALIDARTARJETA(?,?,?,?,?)}");
            ocs.setString(1, numero);
            ocs.setInt(2, dv);
            ocs.setInt(3, mes_venc);
            ocs.setInt(4, ano_venc);
            ocs.registerOutParameter(5, OracleTypes.CURSOR);
            ocs.execute();
            rs = (ResultSet) ocs.getObject(5);
            while (rs.next()) {
                Tarjeta tarjeta = new Tarjeta();
                tarjeta.setNumero(rs.getString("NUMERO"));
                tarjeta.setDv(rs.getInt("DV"));
                tarjeta.setMes_venc(rs.getInt("MES_VENC"));
                tarjeta.setAno_venc(rs.getInt("ANO_VENC"));
                listaTarjetas.add(tarjeta);
            }
            if (listaTarjetas.size() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        } finally {
            con.close();
        }

    }
}
