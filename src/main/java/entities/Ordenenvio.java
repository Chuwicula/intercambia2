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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author nicol
 */
@Entity
@Table(name = "ordenenvio")
public class Ordenenvio implements Serializable {

    @Id
    @Column(name = "idordenenvio")
    private Integer idordenenvio;

    @JoinColumn(name = "idsolicitud")
    @OneToOne
    private Solicitud solicitud;

    private String direccionorigen;
    private String nombreorigen;
    private String nombredestino;
    private String direcciondestino;

    /**
     * @return the idordenenvio
     */
    public Integer getIdordenenvio() {
        return idordenenvio;
    }

    /**
     * @param idordenenvio the idordenenvio to set
     */
    public void setIdordenenvio(Integer idordenenvio) {
        this.idordenenvio = idordenenvio;
    }

    /**
     * @return the solicitud
     */
    public Solicitud getSolicitud() {
        return solicitud;
    }

    /**
     * @param solicitud the solicitud to set
     */
    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    /**
     * @return the direccionorigen
     */
    public String getDireccionorigen() {
        return direccionorigen;
    }

    /**
     * @param direccionorigen the direccionorigen to set
     */
    public void setDireccionorigen(String direccionorigen) {
        this.direccionorigen = direccionorigen;
    }

    /**
     * @return the nombreorigen
     */
    public String getNombreorigen() {
        return nombreorigen;
    }

    /**
     * @param nombreorigen the nombreorigen to set
     */
    public void setNombreorigen(String nombreorigen) {
        this.nombreorigen = nombreorigen;
    }

    /**
     * @return the nombredestino
     */
    public String getNombredestino() {
        return nombredestino;
    }

    /**
     * @param nombredestino the nombredestino to set
     */
    public void setNombredestino(String nombredestino) {
        this.nombredestino = nombredestino;
    }

    /**
     * @return the direcciondestino
     */
    public String getDirecciondestino() {
        return direcciondestino;
    }

    /**
     * @param direcciondestino the direcciondestino to set
     */
    public void setDirecciondestino(String direcciondestino) {
        this.direcciondestino = direcciondestino;
    }

}
