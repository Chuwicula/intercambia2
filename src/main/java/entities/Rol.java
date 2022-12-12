/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author nicol
 */
@Entity
@Table(name = "rol")
@NamedQueries({
      @NamedQuery(name="Rol.findAll",
                  query="SELECT a FROM Rol a")
        })
public class Rol implements Serializable {

    @Id
    @Column(name = "idrol")
    private Integer idRol;

    @Column(name = "nombrerol")
    private String nombreRol;

    public Rol() {

    }

    /**
     * @return the nombreRol
     */
    public String getNombreRol() {
        return nombreRol;
    }

    /**
     * @param nombreRol the nombreRol to set
     */
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    /**
     * @return the idRol
     */
    public Integer getIdRol() {
        return idRol;
    }

    /**
     * @param idRol the idRol to set
     */
    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
    
    @Override
    public String toString(){
        return nombreRol + " id: " + idRol;
    }
}

