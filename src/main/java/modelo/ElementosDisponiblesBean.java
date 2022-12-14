/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entities.Elemento;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import mapper.ElementosMapper;
import sesion.AdministradorSesion;

/**
 *
 * @author nicol
 */
@Named(value = "elementosDisponiblesBean")
@ViewScoped
public class ElementosDisponiblesBean implements Serializable {

    @Inject
    ElementosMapper elementosMapper;

    @Inject
    AdministradorSesion sessionBean;

    private Set<Elemento> elementosDisponibles;
    
    private int indexactivo;

    @PostConstruct
    public void init() {
        System.out.println("INICIANDO BEAN");
        elementosDisponibles = new HashSet<>();
        elementosDisponibles.addAll(elementosMapper.getElementosDisponibles(sessionBean.getUsuario()));
    }

    /**
     * @return the elementosDisponibles
     */
    public Set<Elemento> getElementosDisponibles() {
        return elementosDisponibles;
    }

    /**
     * @param elementosDisponibles the elementosDisponibles to set
     */
    public void setElementosDisponibles(Set<Elemento> elementosDisponibles) {
        this.elementosDisponibles = elementosDisponibles;
    }

    /**
     * @return the indexactivo
     */
    public int getIndexactivo() {
        return indexactivo;
    }

    /**
     * @param indexactivo the indexactivo to set
     */
    public void setIndexactivo(int indexactivo) {
        System.out.println("index "+ indexactivo);
        this.indexactivo = indexactivo;
    }

}
