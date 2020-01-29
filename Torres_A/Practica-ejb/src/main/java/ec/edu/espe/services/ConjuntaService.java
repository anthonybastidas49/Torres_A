/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.services;

import ec.edu.espe.dao.FuncionalidadDAO;
import ec.edu.espe.dao.ModuloDAO;
import ec.edu.espe.model.Funcionalidad;
import ec.edu.espe.model.Modulo;
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
public class ConjuntaService {

    @EJB
    private FuncionalidadDAO funcionalidadDAO;
    @EJB
    private ModuloDAO moduloDAO;

    public List<Modulo> listarTodos() {
        return moduloDAO.findAll();
    }

    public List<Funcionalidad> listarFuncionalidad() {
        return funcionalidadDAO.findAll();
    }

    public List<Funcionalidad> buscarPorModulo(String codigoModulo) {
        return funcionalidadDAO.buscarPorModulo(codigoModulo);
    }

    public void crearFuncionaliad(Funcionalidad funcionalidad) {
        funcionalidadDAO.create(funcionalidad);
    }

    public void eliminarFuncionalidad(Funcionalidad funcionalidad) {
        funcionalidadDAO.remove(funcionalidad);
    }

}
