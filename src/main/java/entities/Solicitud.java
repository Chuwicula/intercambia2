/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @JoinColumn(name = "idelementoofrecido")
    @ManyToOne
    private Elemento idelementoofrecido;

    @Column(name = "estado")
    private Integer estado;

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
    public Integer getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    /**
     * @return the idelementoofrecido
     */
    public Elemento getIdelementoofrecido() {
        return idelementoofrecido;
    }

    /**
     * @param idelementoofrecido the idelementoofrecido to set
     */
    public void setIdelementoofrecido(Elemento idelementoofrecido) {
        this.idelementoofrecido = idelementoofrecido;
    }

}
