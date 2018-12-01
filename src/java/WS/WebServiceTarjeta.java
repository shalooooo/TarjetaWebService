/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import Controlador.CobroTarjetaDAO;
import Controlador.TarjetaDAO;

/**
 *
 * @author Ricardo Pasten
 */
@WebService(serviceName = "WebServiceTarjeta")
public class WebServiceTarjeta {
//String  numeroTarjeta, int monto

    /**
     * Este Web Service Realiza el cobro, se recibe el numero de tarjeta y el
     * monto.
     *
     * @param numeroTarjeta
     * @param monto
     * @return
     */
    @WebMethod(operationName = "ServicioCobroTarjeta")
    public boolean ServicioCobroTarjeta(@WebParam(name = "numertoTarjeta") String numeroTarjeta,
            @WebParam(name = "monto") int monto) {
        CobroTarjetaDAO tarjetaDAO = new CobroTarjetaDAO();
        return tarjetaDAO.CobroTarjeta(numeroTarjeta, monto);
    }

    /**
     * Este Web Service Realiza la validación de la tarjeta
     *
     * @param numeroTarjeta
     * @param dv
     * @param mesVenc
     * @param anoVenc
     * @return 
     *
     */
    @WebMethod(operationName = "ServicioValidacionTarjeta")
    public boolean ServicioValidacipnTarjeta(@WebParam(name = "numeroTarjeta") String numeroTarjeta,
            @WebParam(name = "DV") int dv, @WebParam(name = "mes_venc") int mesVenc,
            @WebParam(name = "ano_venc") int anoVenc) {
        TarjetaDAO tarDAO = new TarjetaDAO();
        return tarDAO.validarTarjeta(numeroTarjeta, dv, mesVenc, anoVenc);
    }
}
