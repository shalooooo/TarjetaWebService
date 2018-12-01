/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ricardo Pasten
 */
public class Conexion {

    private Connection cnn;
    private final String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:xe";
    private final String Usuario = "webservice_tarjeta";
    private final String Pass = "webservice_tarjeta";

    public Conexion() {
        this.conectar();
    }

    public Connection getCnn() {
        return cnn;
    }

    public void setCnn(Connection cnn) {
        this.cnn = cnn;
    }

    public Conexion conectar() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            //String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:xe";
            cnn = DriverManager.getConnection(BaseDeDatos, Usuario, Pass);
            if (cnn == null) {
                System.out.println("Conexion fallida");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error" + e);
        }
        return this;
    }

    public void desonectarBD() {
        try {
            this.getCnn().close();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }

    }

    public void close() {
        try {
            cnn.close();
        } catch (Exception e) {
            System.out.println("error cerrando la conexion");
        }
    }
}
