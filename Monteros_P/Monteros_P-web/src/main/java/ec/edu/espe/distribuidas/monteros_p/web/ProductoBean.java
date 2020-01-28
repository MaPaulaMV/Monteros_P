/*
 * ESPE - DCC - APLICACIONES DISTRIBUIDAS
 * Sistema: Monteros_P-web
 * 
 * Creado: 28/01/2020 - 8:24:57
 * 
 * Los contenidos de este archivo son propiedad privada y estan protegidos por la licencia BSD.
 * 
 * 
 * Se puede utilizar, reproducir o copiar el contenido de este archivo.
 */
package ec.edu.espe.distribuidas.monteros_p.web;

import ec.edu.espe.distribuidas.monteros_p.enums.TipoProductoEnum;
import ec.edu.espe.distribuidas.monteros_p.model.Producto;
import ec.edu.espe.distribuidas.monteros_p.services.ProductoService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Paula
 */
@Named
@ViewScoped
public class ProductoBean implements Serializable{
    
    @Inject
    private ProductoService service;
    
    private Producto producto;
    private Producto productoSelccion;
    private List<Producto> productos;
    private Boolean mostrar;
    private Boolean btnNuevo;
    private Boolean btnModificar;
    private Boolean btnEliminar;
    private Integer accion=0;
    private TipoProductoEnum tipos;
    
    @PostConstruct
    public void init(){
        producto=new Producto();
        productoSelccion=new Producto();
        productos=service.obtenerTodos();
        mostrar=false;
        btnNuevo=false;
        btnModificar=true;
        btnEliminar=true;
        accion=0;
    }
    
    public void accionBoton(){
        switch(accion){
            case 1:
                service.insertar(producto);
                break;
            case 2:
                service.actualizar(producto);
                break;                
            case 3:
                service.eliminar(producto);
                mostrarMensaje("ELIMINAR", "Se ha eliminado el elemneto Exitosamente!");
                break;
        }
    }
    
    public void nuevo(){
        producto=new Producto();
        accion=1;
        mostrar=true;
        deshabilitarBtns();
    }
    
    public void editar(){
        producto=productoSelccion;
        accion=2;
        mostrar=true;
        deshabilitarBtns();
        
    }
    
    public void eliminar(){
        producto=productoSelccion;
        accion=3;
        accionBoton();
        producto=new Producto();
        productoSelccion=new Producto();
        productos=service.obtenerTodos();
        accion=0;
        habilitarBtns();        
    }
    
    public void guardar(){
        accionBoton();
        producto=new Producto();
        productos=service.obtenerTodos();
        accion=0;
        mostrar=false;
        habilitarBtns();
    }

    public void cancelar(){
        producto=new Producto();
        accion=0;
        mostrar=false;
        habilitarBtns();
    }
    
    public void seleccion(){
        btnModificar=false;
        btnEliminar=false;
    }
    
    public void habilitarBtns(){
        btnNuevo=false;
        if(productoSelccion.getCodigo()!=null){
            btnModificar=false;
            btnEliminar=false;
        }else{
            btnModificar=true;
            btnEliminar=true;
        }
    }
    
    public void deshabilitarBtns(){
        btnNuevo=true;
        btnModificar=true;
        btnEliminar=true;
    }

    public ProductoService getService() {
        return service;
    }
    
    public void mostrarMensaje(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }


    public void setService(ProductoService service) {
        this.service = service;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getProductoSelccion() {
        return productoSelccion;
    }

    public void setProductoSelccion(Producto productoSelccion) {
        this.productoSelccion = productoSelccion;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Boolean getMostrar() {
        return mostrar;
    }

    public void setMostrar(Boolean mostrar) {
        this.mostrar = mostrar;
    }

    public Boolean getBtnNuevo() {
        return btnNuevo;
    }

    public void setBtnNuevo(Boolean btnNuevo) {
        this.btnNuevo = btnNuevo;
    }

    public Boolean getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(Boolean btnModificar) {
        this.btnModificar = btnModificar;
    }

    public Boolean getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(Boolean btnEliminar) {
        this.btnEliminar = btnEliminar;
    } 

    public Integer getAccion() {
        return accion;
    }

    public void setAccion(Integer accion) {
        this.accion = accion;
    }

    public TipoProductoEnum[] getTipos() {
        return tipos.values();
    }

    public void setTipos(TipoProductoEnum tipos) {
        this.tipos = tipos;
    }
    
    
    
    
    
}
