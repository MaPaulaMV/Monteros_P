/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.monteros_p.dao;

import ec.edu.espe.distribuidas.monteros_p.model.Padre;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Paula
 */
@Stateless
@LocalBean
public class PadreDAO extends AbstractDAO<Padre>{

    public PadreDAO() {
        super(Padre.class);
    }    
}
