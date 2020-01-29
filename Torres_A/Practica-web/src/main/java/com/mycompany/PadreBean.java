/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.sun.prism.impl.BaseMesh;
import ec.edu.espe.enums.EstadoCivilPadreEnums;
import ec.edu.espe.model.Padre;
import ec.edu.espe.services.PadreService;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Anthony
 */
@Named
@ViewScoped
public class PadreBean implements Serializable {

    @Inject
    private PadreService service;

    private static final Logger LOG = Logger.getLogger(PadreBean.class.getName());
    private List<Padre> padres;
    private Padre padre;
    private Padre padreModificar;
    private boolean enNuevo;
    private boolean enModificar;
    private boolean enEliminar;
    private boolean esSelecconado;
    private Integer tipoAccion = 0;
    private EstadoCivilPadreEnums estadoCivil;

    @PostConstruct
    public void initIt() {
        padre = new Padre();
        padreModificar = new Padre();
        
        padres = service.buscarTodo();
        esSelecconado = false;
        enNuevo = false;
        enModificar = true;
        enEliminar = true;
    }

    public void seleccion() {
        enModificar = false;
        enEliminar = false;
    }

    public void getAllPadres() {
        try {
            padres = this.service.buscarTodo();
        } catch (RuntimeException e) {
            LOG.info("Error en el búsqueda");
        }
    }

    public void accionesBoton() {
        switch (tipoAccion) {
            case 1:
                service.insertar(padre);
                break;
            case 2:
                service.editar(padre);
                break;
            case 3:
                service.borrar(padre);
                addMessage("ELIMINAR", "EXITOSO!");
                break;
        }
    }

    public String guardar() {
        accionesBoton();
        padres = service.buscarTodo();
        cancelar();
        tipoAccion = 0;
        padre = new Padre();
        return "#";
    }

    public void cancelar() {
        desbloquear();
        padre = new Padre();
        tipoAccion = 0;
    }

    public String nuevo() {
        tipoAccion = 1;
        bloquear();
        return "#";
    }

    public String modificar() {
        tipoAccion = 2;
        padre = padreModificar;
        bloquear();
        return "#";
    }

    public String eliminar() {
        tipoAccion = 3;
        padre = padreModificar;
        accionesBoton();
        tipoAccion = 0;
        padre = new Padre();
        padres = service.buscarTodo();
        return "#";
    }

    public EstadoCivilPadreEnums[] getEstadoCivil() {
        return estadoCivil.values();
    }

    public void desbloquear() {
        esSelecconado = false;
        enNuevo = false;
        enModificar = true;
        enEliminar = true;
    }

    public void bloquear() {
        esSelecconado = true;
        enNuevo = true;
        enModificar = true;
        enEliminar = true;
    }

    public PadreService getService() {
        return service;
    }

    public Integer getTipoAccion() {
        return tipoAccion;
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void setTipoAccion(Integer tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    public void setService(PadreService service) {
        this.service = service;
    }

    public Padre getPadre() {
        return padre;
    }

    public Padre getPadreModificar() {
        return padreModificar;
    }

    public void setPadreModificar(Padre padreModificar) {
        this.padreModificar = padreModificar;
    }

    public void setPadre(Padre padre) {
        this.padre = padre;
    }

    public boolean isEnModificar() {
        return enModificar;
    }

    public boolean isEnEliminar() {
        return enEliminar;
    }

    public List<Padre> getPadres() {
        return padres;
    }

    public boolean isEsSelecconado() {
        return esSelecconado;
    }

    public void setPadres(List<Padre> padres) {
        this.padres = padres;
    }

    public boolean isEnNuevo() {
        return enNuevo;
    }

}
