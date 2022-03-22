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
public class Datos {
    private double costoUnitario;
    private double costoPorPedido;
    private double tasaCostoRetencion;
    private double z;
    private double demandaMedia;
    private double desviacion;
    private int tiempoRepo;
    private double diasHabiles;
    private double cantidadQ;
    private double demandaAnual;
    private double cantidadActual;
    private int cantidadAPedirSiempre;
    public Datos(){
        
    }

    public Datos(double costoUnitario, double costoPorPedido, double tasaCostoRetencion, double z, double demandaMedia, double desviacion, int tiempoRepo, double diasHabiles) {
        this.costoUnitario = costoUnitario;
        this.costoPorPedido = costoPorPedido;
        this.tasaCostoRetencion = tasaCostoRetencion;
        this.z = z;
        this.demandaMedia = demandaMedia;
        this.desviacion = desviacion;
        this.tiempoRepo = tiempoRepo;
        this.diasHabiles = diasHabiles;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public double getCostoPorPedido() {
        return costoPorPedido;
    }

    public void setCostoPorPedido(double costoPorPedido) {
        this.costoPorPedido = costoPorPedido;
    }

    public double getTasaCostoRetencion() {
        return tasaCostoRetencion;
    }

    public void setTasaCostoRetencion(double tasaCostoRetencion) {
        this.tasaCostoRetencion = tasaCostoRetencion;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getDemandaMedia() {
        return demandaMedia;
    }

    public void setDemandaMedia(double demandaMedia) {
        this.demandaMedia = demandaMedia;
    }

    public double getDesviacion() {
        return desviacion;
    }

    public void setDesviacion(double desviacion) {
        this.desviacion = desviacion;
    }

    public int getTiempoRepo() {
        return tiempoRepo;
    }

    public void setTiempoRepo(int tiempoRepo) {
        this.tiempoRepo = tiempoRepo;
    }

    public double getDiasHabiles() {
        return diasHabiles;
    }

    public void setDiasHabiles(double diasHabiles) {
        this.diasHabiles = diasHabiles;
    }

    public double getCantidadQ() {
        return cantidadQ;
    }

    public void setCantidadQ(double cantidadQ) {
        this.cantidadQ = cantidadQ;
    }

    public double getDemandaAnual() {
        return demandaAnual;
    }

    public void setDemandaAnual(double demandaAnual) {
        this.demandaAnual = demandaAnual;
    }

    public double getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(double cantidadActual) {
        this.cantidadActual = cantidadActual;
    }
    
    private void demandaAnual(){
        this.demandaAnual = this.demandaMedia*this.diasHabiles;
    }
    public void calcularCantidadQ(){
        demandaAnual();
        cantidadQ = Math.sqrt((2*demandaAnual*costoPorPedido)/(tasaCostoRetencion*costoUnitario));
        cantidadAPedirSiempre = (int)cantidadQ;
    }
    
    
    public int obtenerPuntoReorden(){
        return (int)Math.round(demandaMedia + z*desviacion);
    }
    public int getStockSecurity(){
        return ((int) (this.obtenerPuntoReorden()-this.demandaMedia));
        
    }
    
    public void calcularInventarioActual(double ocurrenciaDemanda){
        this.cantidadQ = this.cantidadQ - ocurrenciaDemanda;
    }
    public void inventarioActualDESPUESDELPEDIDO(){
        this.cantidadQ = this.cantidadQ + this.cantidadAPedirSiempre;
    }
    
    
    public double getCostoTotal(){
        return ((demandaAnual/cantidadQ)*costoPorPedido + (cantidadQ*costoUnitario*tasaCostoRetencion)/2 + getStockSecurity()*costoUnitario*tasaCostoRetencion);
    }
}
