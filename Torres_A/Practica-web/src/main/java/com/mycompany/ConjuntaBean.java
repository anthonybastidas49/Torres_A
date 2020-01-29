/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import ec.edu.espe.model.Funcionalidad;
import ec.edu.espe.model.Modulo;
import ec.edu.espe.services.ConjuntaService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Anthony
 */
@Named
@ViewScoped
public class ConjuntaBean implements Serializable {
    @Inject
    private ConjuntaService service;
    
    private boolean esFuncionalidad;
    private boolean esDespleagable;
    private Funcionalidad funcionaliadaS;
    private boolean nuevoTemplate;
    private String nombre;
    private List<Modulo> listaModulos;
    private List<Funcionalidad> listaFuncionalidades;
    private Modulo modulo;
    private Funcionalidad nuevaFuncionalidad;
    
    @PostConstruct
    public void initIt() {
        modulo=new Modulo();
        funcionaliadaS=new Funcionalidad();
        nuevaFuncionalidad=new Funcionalidad();
        esDespleagable=false;
        nuevoTemplate=false;
        esFuncionalidad=true;
        listaModulos=service.listarTodos();
    }

    public List<Modulo> getListaModulos() {
        return listaModulos;
    }
    public String desplegarPanel(){
        esDespleagable=true;
        nombre="FUNCIONALIDAD DE MODULO "+modulo.getNombre();
//        listaFuncionalidades=service.buscarPorModulo(modulo.getCodigo());
         listaFuncionalidades=service.listarFuncionalidad();
        return "#";
    }
    public void seleccion() {
        esFuncionalidad=false;
    }
    public void deseleccion() {
        esFuncionalidad=true;
    }
    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }
    public String eliminarFuncionalidad(){
        service.eliminarFuncionalidad(funcionaliadaS);
        listaFuncionalidades=service.listarFuncionalidad();
        return "#";
    }

    public boolean isNuevoTemplate() {
        return nuevoTemplate;
    }
    public void cancelarNuevo(){
        nuevoTemplate=false;
    }
    
    public List<Funcionalidad> getListaFuncionalidades() {
        return listaFuncionalidades;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public String getNombre() {
        return nombre;
    }

    public Funcionalidad getFuncionaliadaS() {
        return funcionaliadaS;
    }

    public void setFuncionaliadaS(Funcionalidad funcionaliadaS) {
        this.funcionaliadaS = funcionaliadaS;
    }

    public boolean isEsDespleagable() {
        return esDespleagable;
    }

    public boolean isEsFuncionalidad() {
        return esFuncionalidad;
    }

    public Funcionalidad getNuevaFuncionalidad() {
        return nuevaFuncionalidad;
    }

    public void setNuevaFuncionalidad(Funcionalidad nuevaFuncionalidad) {
        this.nuevaFuncionalidad = nuevaFuncionalidad;
    }
    
    
    
}
