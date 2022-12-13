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

/**
 *
 * @author nicol
 */
@Entity
public class Credenciales implements Serializable {

    @Id
    @OneToOne()
    @JoinColumn(name = "idusuario")
    private Usuario idusuario;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "contraseña")
    private String contrasena;

    public Credenciales() {

    }

    /**
     * @return the idusuario
     */
    public Usuario getIdusuario() {
        return idusuario;
    }

    /**
     * @param idusuario the idusuario to set
     */
    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
