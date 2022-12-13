/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entities.Categoria;
import entities.Elemento;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import mapper.CategoriaMapper;
import mapper.ElementosMapper;
import sesion.AdministradorSesion;

/**
 *
 * @author nicol
 */
@Named(value = "misElementosBean")
@ViewScoped
public class MisElementosBean implements Serializable {
    
    @Inject
    ElementosMapper elementosMapper;
    
    @Inject
    AdministradorSesion sessionBean;
    
    @Inject
    CategoriaMapper categoriaMapper;
    
    private Set<Elemento> elementosDisponibles;
    
    private Set<Categoria> categorias;
    
    private Map<Integer, Categoria> categoriaMap;
    
    private Integer idCategoria;
    
    private Elemento nuevoElemento;
    
    @PostConstruct
    public void init() {
        elementosDisponibles = new HashSet<>();
        elementosDisponibles.addAll(elementosMapper.getElementosUsuario(sessionBean.getUsuario()));
        nuevoElemento = new Elemento();
        
        categorias = new HashSet<>();
        categorias.addAll(categoriaMapper.getAll());
        
        categoriaMap = new HashMap<>();
        
        for (Categoria ca : categorias) {
            categoriaMap.put(ca.getIdcategoria(), ca);
        }
        
    }
    
    public void crearElemento() {
        System.out.println("Categoria : " + idCategoria);
        System.out.println("Get categoria :" + categoriaMap.get(idCategoria));
        nuevoElemento.setIdcategoria(categoriaMap.get(idCategoria));
        //System.out.println("Categoría: " + nuevoElemento.getIdcategoria().getNombrecategoria());
        System.out.println("estado: " + nuevoElemento.isEsnuevo());
        
        elementosMapper.crear(nuevoElemento);
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
     * @return the nuevoElemento
     */
    public Elemento getNuevoElemento() {
        return nuevoElemento;
    }

    /**
     * @param nuevoElemento the nuevoElemento to set
     */
    public void setNuevoElemento(Elemento nuevoElemento) {
        this.nuevoElemento = nuevoElemento;
    }

    /**
     * @return the categorias
     */
    public Set<Categoria> getCategorias() {
        return categorias;
    }

    /**
     * @param categorias the categorias to set
     */
    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }

    /**
     * @return the idCategoria
     */
    public Integer getIdCategoria() {
        return idCategoria;
    }

    /**
     * @param idCategoria the idCategoria to set
     */
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
    
}
