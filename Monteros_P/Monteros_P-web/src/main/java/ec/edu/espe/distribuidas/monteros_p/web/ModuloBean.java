/*
 * ESPE - DCC - APLICACIONES DISTRIBUIDAS
 * Sistema: Monteros_P-web
 * 
 * Creado: 28/01/2020 - 20:14:57
 * 
 * Los contenidos de este archivo son propiedad privada y estan protegidos por la licencia BSD.
 * 
 * 
 * Se puede utilizar, reproducir o copiar el contenido de este archivo.
 */
package ec.edu.espe.distribuidas.monteros_p.web;

import ec.edu.espe.distribuidas.monteros_p.model.Funcionalidad;
import ec.edu.espe.distribuidas.monteros_p.model.Modulo;
import ec.edu.espe.distribuidas.monteros_p.services.ModuloService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Paula
 */
@Named
@ViewScoped
public class ModuloBean implements Serializable{
    
    @Inject
    private ModuloService service;
    
    private Modulo moduloSelccion;
    private List<Modulo> modulos;
    private Funcionalidad funcionalidadSelccion;
    private Funcionalidad funcionalidad;
    private List<Funcionalidad> funcionalidades;
    private Boolean btnMostrar;
    private Boolean mostrar;
    private Boolean mostrarFuncionalidad;
    private Boolean btnNuevo;
    private Boolean btnDetalles;
    private Boolean btnEliminar;
    private String titulo;
    
    @PostConstruct
    public void init(){
        modulos=service.obtenerTodosModulos();
        funcionalidad=new Funcionalidad();
        btnMostrar=true;
        mostrar=false;
        btnNuevo=false;
        btnDetalles=true;
        btnEliminar=true;
        mostrarFuncionalidad=false;
   
        titulo="Listado Funcionalidades del Modulo ";
    }
    
    public void mostrarFuncionalidades(){
        funcionalidades=service.obtenerPorModulo(moduloSelccion.getCodigo());
        titulo=titulo+moduloSelccion.getNombre();
        mostrar=true;
    }
    
    public void seleccionModulo(){
        btnMostrar=false;
    }
    
    public void seleccionFuncionalidad(){
        btnDetalles=false;
        btnEliminar=false;
    }
    
    
    
    public void detalles(){
        funcionalidad=funcionalidadSelccion;
        mostrarFuncionalidad=true;
        deshabilitarBtns();
    }
    public void cancelar(){
        funcionalidad=new Funcionalidad();        
        mostrar=false;
        habilitarBtns();
    }
    
    public void eliminar(){
        funcionalidad=funcionalidadSelccion;
        service.delete(funcionalidad);
        funcionalidad=new Funcionalidad();
        funcionalidadSelccion=new Funcionalidad();
        funcionalidades=service.obtenerPorModulo(moduloSelccion.getCodigo());
        habilitarBtns();   
        
    }
    
    
    public void habilitarBtns(){
        btnNuevo=false;
        if(funcionalidadSelccion.getCodigo()!=null){
            btnDetalles=false;
            btnEliminar=false;
        }else{
            btnDetalles=true;
            btnEliminar=true;
        }
    }
    
    public void deshabilitarBtns(){
        btnNuevo=true;
        btnDetalles=true;
        btnEliminar=true;
    }


    public ModuloService getService() {
        return service;
    }

    public void setService(ModuloService service) {
        this.service = service;
    }

    public Modulo getModuloSelccion() {
        return moduloSelccion;
    }

    public void setModuloSelccion(Modulo moduloSelccion) {
        this.moduloSelccion = moduloSelccion;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    public Funcionalidad getFuncionalidadSelccion() {
        return funcionalidadSelccion;
    }

    public void setFuncionalidadSelccion(Funcionalidad funcionalidadSelccion) {
        this.funcionalidadSelccion = funcionalidadSelccion;
    }

    public Funcionalidad getFuncionalidad() {
        return funcionalidad;
    }

    public void setFuncionalidad(Funcionalidad funcionalidad) {
        this.funcionalidad = funcionalidad;
    }

    public List<Funcionalidad> getFuncionalidades() {
        return funcionalidades;
    }

    public void setFuncionalidades(List<Funcionalidad> funcionalidades) {
        this.funcionalidades = funcionalidades;
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

    public Boolean getBtnDetalles() {
        return btnDetalles;
    }

    public void setBtnDetalles(Boolean btnDetalles) {
        this.btnDetalles = btnDetalles;
    }

    public Boolean getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(Boolean btnEliminar) {
        this.btnEliminar = btnEliminar;
    }
    
    public Boolean getBtnMostrar() {
        return btnMostrar;
    }

    public void setBtnMostrar(Boolean btnMostrar) {
        this.btnMostrar = btnMostrar;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getMostrarFuncionalidad() {
        return mostrarFuncionalidad;
    }

    public void setMostrarFuncionalidad(Boolean mostrarFuncionalidad) {
        this.mostrarFuncionalidad = mostrarFuncionalidad;
    }
    
    
    
    
 
    
}
