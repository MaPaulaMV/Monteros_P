/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.monteros_p.web;

import ec.edu.espe.distribuidas.monteros_p.enums.EstadoCivilPadreEnums;
import ec.edu.espe.distribuidas.monteros_p.model.Padre;
import ec.edu.espe.distribuidas.monteros_p.services.PadreService;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
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
public class PadreBean implements Serializable {

    @Inject
    private PadreService service;

    private static final Logger LOG = Logger.getLogger(PadreBean.class.getName());
    private List<Padre> padres;
    private Padre padre;
    private Padre padreModificar;
    private boolean enNuevo;
    private boolean enModificar;
    private boolean enEliminar;
    private boolean esSelecconado;
    private Integer tipoAccion = 0;
    private EstadoCivilPadreEnums estadoCivil;

    @PostConstruct
    public void initIt() {
        padre = new Padre();
        padreModificar = new Padre();
        padres = service.buscarTodo();
        esSelecconado = false;
        enNuevo = false;
        enModificar = true;
        enEliminar = true;
    }   

    public void accionesBoton() {
        switch (tipoAccion) {
            case 1:
                service.insertar(padre);
                break;
            case 2:
                service.editar(padre);
                break;
            case 3:
                service.remover(padre);
                mostrarMensaje("ELIMINAR", "Se ha eliminado el elemneto Exitosamente!");
                break;
        }
    }
    
    public void seleccion(){
        enModificar=false;
        enEliminar=false;
    }

    public void guardar() {
        accionesBoton();
        padres = service.buscarTodo();
        cancelar();
        tipoAccion = 0;
        padre=new Padre();
        
    }

    public void cancelar() {
        desbloquear();
        padre=new Padre();
        tipoAccion = 0;
    }

    public void nuevo() {
        tipoAccion = 1;
        bloquear();
        
    }

    public void modificar() {
        tipoAccion = 2;
        padre = padreModificar;
        bloquear();        
    }

    public void eliminar() {
        tipoAccion = 3;
        padre=padreModificar;
        accionesBoton();
        padre=new Padre();
        padres=service.buscarTodo();
        tipoAccion=0;
    }

    public EstadoCivilPadreEnums[] getEstadoCivil() {
        return estadoCivil.values();
    }

    public void desbloquear() {
        esSelecconado = false;
        enNuevo = false;
        enModificar = false;
        enEliminar = false;
    }

    public void bloquear() {
        esSelecconado = true;
        enNuevo = true;
        enModificar = true;
        enEliminar = true;
    }
    
    public void mostrarMensaje(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public PadreService getService() {
        return service;
    }

    public Integer getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(Integer tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    public void setService(PadreService service) {
        this.service = service;
    }

    public Padre getPadre() {
        return padre;
    }

    public Padre getPadreModificar() {
        return padreModificar;
    }

    public void setPadreModificar(Padre padreModificar) {
        this.padreModificar = padreModificar;
    }

    public void setPadre(Padre padre) {
        this.padre = padre;
    }

    public boolean isEnModificar() {
        return enModificar;
    }

    public boolean isEnEliminar() {
        return enEliminar;
    }

    public List<Padre> getPadres() {
        return padres;
    }

    public boolean isEsSelecconado() {
        return esSelecconado;
    }

    public void setPadres(List<Padre> padres) {
        this.padres = padres;
    }

    public boolean isEnNuevo() {
        return enNuevo;
    }
    
    

}
