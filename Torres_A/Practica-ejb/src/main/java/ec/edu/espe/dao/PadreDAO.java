/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.dao;

import ec.edu.espe.model.Padre;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Anthony
 */
@Stateless
@LocalBean
public class PadreDAO extends AbstractDAO<Padre>{

    public PadreDAO() {
        super(Padre.class);
    }    
}
