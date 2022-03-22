/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.util.Scanner;

/**
 *
 * @author Nahuel
 */
public class Controlador {

    Scanner sc = new Scanner(System.in);
    double cantidad = 1;
    Datos d;

    public Controlador(Datos d) {
        this.d = d;
    }

    public void operar() {

        do {

            System.out.print("Ingrese ocurrencia demanda (Cantidad Demandada diaria) --> ");
            cantidad = sc.nextDouble();
            d.calcularInventarioActual(cantidad);
            if (d.getCantidadQ() <= d.obtenerPuntoReorden()) {
                System.out.println("LLEGAMOS AL PUNTO DE REORDEN... Inventario: "+d.getCantidadQ());
                System.out.println("---------------------------------");
                System.out.println("Nuevo pedido realizado.");
                System.out.println("---------------------------------");
                System.out.println("PEDIDO LLEGARA EN LOS PROXIMOS " + d.getTiempoRepo() + " DIAS");
                for (int i = 1; i <= d.getTiempoRepo(); i++) {
                    System.out.print("Ingrese ocurrencia demanda (Cantidad Demandada diaria) --> ");
                    cantidad = sc.nextDouble();
                    d.calcularInventarioActual(cantidad);

                }
                System.out.println("");
                d.inventarioActualDESPUESDELPEDIDO();
                System.out.println("---------------------------------");
                System.out.println("INVENTARIO ACTUAL --->" + d.getCantidadQ());
                System.out.println("---------------------------------");
                System.out.println("");
            }

        } while (true);

    }

}
