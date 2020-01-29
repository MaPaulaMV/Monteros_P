/*
 * ESPE - DCC - APLICACIONES DISTRIBUIDAS
 * Sistema: Global-ejb
 * 
 * Creado: 17/12/2019 - 18:46:24
 * 
 * Los contenidos de este archivo son propiedad privada y estan protegidos por la licencia BSD.
 * 
 * 
 * Se puede utilizar, reproducir o copiar el contenido de este archivo.
 */
package ec.edu.espe.distribuidas.monteros_p.services;

import ec.edu.espe.distribuidas.global.enums.EstadoActivoInactivoEnum;
import ec.edu.espe.distribuidas.monteros_p.dao.FuncionalidadDAO;
import ec.edu.espe.distribuidas.monteros_p.dao.ModuloDAO;
import ec.edu.espe.distribuidas.monteros_p.model.Funcionalidad;
import ec.edu.espe.distribuidas.monteros_p.model.Modulo;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * Clase que implementa los servicios para el manejo de la tabla SEG_MODULO. Los
 * servicios de esta clase estan relacionados con operaciones CRUD y busqueda.
 *
 * @author Toro Jordan
 * @author Rodriguez Fernando
 */
@Stateless
@LocalBean
public class ModuloService {

    @EJB
    private ModuloDAO daoModulo;
    
    @EJB
    private FuncionalidadDAO daoFuncionalidad;

    /**
     * Obtiene un listado de Modulos.
     *
     * @return Listado Modulos en base al estado.
     */
    public List<Modulo> obtenerTodosModulos() {
        return daoModulo.findAll();
    }
    
    public List<Funcionalidad> obtenerTodosFuncioanlidad(){
        return daoFuncionalidad.findAll();
    }

    /**
     * Obtiene un Modulo en base a la clave primaria.
     *
     * @param codigo El código del modulo con el que se va a realizar la
     * busqueda.
     * @return Modulo en base al código.
     */
    public Modulo obtenerPorPK(String codigo) {
        return daoModulo.find(codigo);
    }

    /**
     * Obtiene un listado de Modulos en base al estado.
     *
     * @param estado Estado de los modulos que se van a buscar.
     *
     * @return Listado Modulos en base al estado.
     */
    public List<Modulo> obtenerPorEstado(EstadoActivoInactivoEnum estado) {
        return daoModulo.findByEstado(estado);
    }

    /**
     * Obtiene un Modulo en base a un nombre.
     *
     * @param nombre Nombre del modulo al cual se busca.
     *
     * @return Un modulo que coincida con el nombre.
     */
    public Modulo obtenerPorNombre(String nombre) {
        return daoModulo.findByNombre(nombre);
    }
    
    public List<Funcionalidad> obtenerPorModulo(String codModulo){
        return daoFuncionalidad.findByCodModulo(codModulo);
    }
    
    
    public void create(Funcionalidad funcionalidad) {
        if(funcionalidad.getModulo()==null){
            throw new UnsupportedOperationException("Error");
        }        
        daoFuncionalidad.create(funcionalidad);
        
    }

    
    public void update(Funcionalidad funcionalidad) {     
        daoFuncionalidad.edit(funcionalidad);
    }
    
    
    public void delete(Funcionalidad funcionalidad){
        daoFuncionalidad.remove(funcionalidad);
    }
    
    

   
}
