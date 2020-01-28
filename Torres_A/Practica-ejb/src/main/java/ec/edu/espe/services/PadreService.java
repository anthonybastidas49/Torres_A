/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.services;

import ec.edu.espe.dao.PadreDAO;
import ec.edu.espe.model.Padre;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Anthony
 */
@Stateless
@LocalBean
public class PadreService {
    
    @EJB
    private PadreDAO dao;
    
    public List<Padre> buscarTodo(){
        return dao.findAll();
    }
    public Padre buscarCodigo(Integer codigo){
        try{
            return dao.find(codigo);
        }catch(Exception e){
            return null;
        }
        
        
    }
    
    public void insertar(Padre padre){
        padre.setCodigo(null);
        dao.create(padre);
    }
    public void editar(Padre padre){
        dao.edit(padre);
    }
    public void borrar(Padre padre){
        dao.remove(padre);
    }
}
