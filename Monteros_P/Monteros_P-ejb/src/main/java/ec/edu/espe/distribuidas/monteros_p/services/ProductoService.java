/*
 * ESPE - DCC - APLICACIONES DISTRIBUIDAS
 * Sistema: Monteros_P-ejb
 * 
 * Creado: 28/01/2020 - 7:29:45
 * 
 * Los contenidos de este archivo son propiedad privada y estan protegidos por la licencia BSD.
 * 
 * 
 * Se puede utilizar, reproducir o copiar el contenido de este archivo.
 */
package ec.edu.espe.distribuidas.monteros_p.services;

import ec.edu.espe.distribuidas.monteros_p.dao.ProductoDAO;
import ec.edu.espe.distribuidas.monteros_p.model.Producto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Paula
 */
@Stateless
@LocalBean
public class ProductoService {
    
    @EJB
    private ProductoDAO dao;
    
    public List<Producto> obtenerTodos(){
        return dao.findAll();
    }
    
    public void insertar(Producto producto){
        dao.create(producto);
    }
    
    public void actualizar(Producto producto){
        dao.edit(producto);
    }
    
    public void eliminar(Producto producto){
        dao.remove(producto);
    }
}
