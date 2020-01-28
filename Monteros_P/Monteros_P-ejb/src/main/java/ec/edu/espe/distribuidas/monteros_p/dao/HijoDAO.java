/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.monteros_p.dao;

import ec.edu.espe.distribuidas.monteros_p.model.Hijo;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Paula
 */
@Stateless
@LocalBean
public class HijoDAO extends AbstractDAO<Hijo> {

    public HijoDAO() {
        super(Hijo.class);
    }

    public List<Hijo> bucarCodigoPadre(Integer codigoPadre) {
        try {
            return this.finder(
                    "SELECT P FROM Padre WHERE P.codigo=?1",
                    new Object[]{
                        codigoPadre
                    });
        } catch (Exception e) {
            return null;
        }
    }
}
