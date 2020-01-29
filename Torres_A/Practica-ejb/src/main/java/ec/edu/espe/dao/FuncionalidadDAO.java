/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.dao;

import ec.edu.espe.model.Funcionalidad;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Anthony
 */
@Stateless
@LocalBean
public class FuncionalidadDAO extends AbstractDAO<Funcionalidad> {
    public FuncionalidadDAO() {
        super(Funcionalidad.class);
    }
    
    public List<Funcionalidad> buscarPorModulo(String codigoModulo) {
        
        try {
            return this.finder(
                    "SELECT P FROM Funcionalidad WHERE P.modulo.codigo=?1",
                    new Object[]{
                        codigoModulo
                    });
        } catch (Exception e) {
            return null;
        }
    }
}
