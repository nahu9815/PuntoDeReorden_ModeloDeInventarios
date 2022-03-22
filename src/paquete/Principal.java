/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

/**
 *
 * @author Nahuel
 */
public class Principal {

    
    public static void main(String[] args) {
        //DATOS(costoU,costoPedido,tasa,z,media,desviacion,tiempoEspera,diasHabiles)
        Datos d = new Datos(10,20,0.20,1.645,200,150,4,250);
        d.calcularCantidadQ();
        
        System.out.println("Cantidad Q a pedir: "+d.getCantidadQ());
        System.out.println("Punto de reorden: "+d.obtenerPuntoReorden());
        System.out.println("Stock de seguridad: "+d.getStockSecurity());
        System.out.println("COSTO TOTAL ---> "+d.getCostoTotal());
        Controlador controlador = new Controlador(d);
        controlador.operar();
    }
    
}
