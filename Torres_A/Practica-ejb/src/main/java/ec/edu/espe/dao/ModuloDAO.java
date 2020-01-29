/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.dao;

import ec.edu.espe.model.Modulo;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Anthony
 */
@Stateless
@LocalBean
public class ModuloDAO extends AbstractDAO<Modulo> {
    public ModuloDAO() {
        super(Modulo.class);
    }
}
