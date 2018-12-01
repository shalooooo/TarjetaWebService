/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Ricardo Pasten
 */
public class CobroTarjetaDAO {
    Conexion con;
    
    public CobroTarjetaDAO()
    {
        con = new  Conexion();
    }
    
    public boolean CobroTarjeta(String  numeroTarjeta, int monto){
        OracleCallableStatement ocs = null;
        Connection en = con.getCnn();
        ResultSet rs = null;
               
        try {
            ocs = (OracleCallableStatement) en.prepareCall("{call COBRO_PKG.SP_INSERTARPAGO(?,?)}");
            ocs.setString(1, numeroTarjeta);
            ocs.setInt(2, monto);
            //ocs.registerOutParameter(2, OracleTypes.CURSOR);
            ocs.execute();
            //rs = (ResultSet) ocs.getObject(2);
            return true;
            /*if (rs!=null)
                return true;
            else
                return false;          */
        } catch (SQLException e) 
        {
            System.out.println(""+e.getMessage());
            return false;
        } finally {
            con.close();
        }
    }
}