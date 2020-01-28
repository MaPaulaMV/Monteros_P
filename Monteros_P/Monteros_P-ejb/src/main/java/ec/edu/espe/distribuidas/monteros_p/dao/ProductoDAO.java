/*
 * ESPE - DCC - APLICACIONES DISTRIBUIDAS
 * Sistema: Monteros_P-ejb
 * 
 * Creado: 28/01/2020 - 7:28:45
 * 
 * Los contenidos de este archivo son propiedad privada y estan protegidos por la licencia BSD.
 * 
 * 
 * Se puede utilizar, reproducir o copiar el contenido de este archivo.
 */
package ec.edu.espe.distribuidas.monteros_p.dao;

import ec.edu.espe.distribuidas.monteros_p.model.Producto;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Paula
 */
@Stateless
@LocalBean
public class ProductoDAO extends AbstractDAO<Producto>{
    
    public ProductoDAO(){
        super(Producto.class);
    }
    
}
