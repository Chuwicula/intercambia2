/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author nicol
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll",
            query = "SELECT a FROM Usuario a"),
    @NamedQuery(name = "Usuario.findByPass",
            query = "SELECT a FROM Usuario a where a.correoElectronico = :mail AND a.contrasena = :pass"),
    @NamedQuery(name = "Usuario.findByMail",
            query = "SELECT COUNT(a) FROM Usuario a where a.correoElectronico = :mail")
})
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "idusuario")
    private Integer idUsuario;

    @Column(name = "correo")
    private String correoElectronico;

    @Column(name = "tipodocumentou")
    private String identificacion;

    @Column(name = "nombreu")
    private String nombreUsuario;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fechanacimientou")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "suscripcion")
    private Integer tipoSuscripcion;

    @Column(name = "direccionu")
    private String direccion;
    
    @Column(name = "contrasena")
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "idrol")
    private Rol rol;

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the correoElectronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * @param correoElectronico the correoElectronico to set
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * @return the identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * @param identificacion the identificacion to set
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the rol
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the tipoSuscripcion
     */
    public Integer getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    /**
     * @param tipoSuscripcion the tipoSuscripcion to set
     */
    public void setTipoSuscripcion(Integer tipoSuscripcion) {
        this.tipoSuscripcion = tipoSuscripcion;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
