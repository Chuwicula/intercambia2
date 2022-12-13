/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author nicol
 */
@Entity
public class Solicitud implements Serializable {

    @Id
    @Column(name = "idsolicitud")
    private Integer idsolicitud;

    @OneToOne(mappedBy = "solicitud")
    private Ordenenvio ordenenvio;

    @ManyToOne
    @JoinColumn(name = "idusuariosolicitante")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idelementosolicitado")
    private Elemento elemento;

    @Column(name = "estado")
    private Boolean estado;

    /**
     * @return the ordenenvio
     */
    public Ordenenvio getOrdenenvio() {
        return ordenenvio;
    }

    /**
     * @param ordenenvio the ordenenvio to set
     */
    public void setOrdenenvio(Ordenenvio ordenenvio) {
        this.ordenenvio = ordenenvio;
    }

    /**
     * @return the idsolicitud
     */
    public Integer getIdsolicitud() {
        return idsolicitud;
    }

    /**
     * @param idsolicitud the idsolicitud to set
     */
    public void setIdsolicitud(Integer idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the elemento
     */
    public Elemento getElemento() {
        return elemento;
    }

    /**
     * @param elemento the elemento to set
     */
    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }

    /**
     * @return the estado
     */
    public Boolean getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
