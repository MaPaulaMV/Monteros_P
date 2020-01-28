/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.monteros_p.services;

import ec.edu.espe.distribuidas.monteros_p.dao.HijoDAO;
import ec.edu.espe.distribuidas.monteros_p.model.Hijo;
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
public class HijoService {
    
    @EJB
    private HijoDAO dao;
    
    public void insertar(Hijo hijo){
        dao.create(hijo);
    }
    
    public void editar(Hijo hijo){
        dao.edit(hijo);
    }
    
    public List<Hijo> buscarTodo(){
        return dao.findAll();
    }
    public Hijo buscarPK(Integer codigo){
        return dao.find(codigo);
    }
}
