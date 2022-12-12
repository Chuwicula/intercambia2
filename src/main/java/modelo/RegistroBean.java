/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entities.Rol;
import entities.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import mapper.RolMapper;
import mapper.UsuarioMapper;
import org.primefaces.PrimeFaces;

/**
 *
 * @author nicol
 */
@Named(value = "registroBean")
@ViewScoped
public class RegistroBean implements Serializable {

    private Usuario nuevoUsuario;

    @Inject
    private UsuarioMapper usuarioMapper;

    @Inject
    private RolMapper rolMapper;

    private String pais;

    private String ciudad;

    private String barrio;

    private String direccion;

    private String suscripcion;

    @PostConstruct
    public void init() {
        nuevoUsuario = new Usuario();

        System.out.println("buenas");
        Rol rolTrocador = getRolMapper().buscar(1);
        nuevoUsuario.setRol(rolTrocador);
        System.out.println(rolMapper.obtenerRoles());
        System.out.println("rol " + rolTrocador);
    }

    public void guardarUsuario() {

        String direccionTotal = pais + " " + ciudad + " " + barrio + " " + direccion;
        nuevoUsuario.setDireccion(direccionTotal);
        nuevoUsuario.setTipoSuscripcion(Integer.parseInt(suscripcion));

        System.out.println("voy a validar");
        if (!usuarioMapper.validarExistenciaUsuario(nuevoUsuario.getCorreoElectronico())) {
            System.out.println("validado, no existe");
            Usuario usuarioGuardado = usuarioMapper.crear(nuevoUsuario);
            if (usuarioGuardado != null) {
                PrimeFaces current = PrimeFaces.current();
                current.executeScript("PF('dlg1').show();");
            }
        } else {
            PrimeFaces current = PrimeFaces.current();
            current.executeScript("PF('dlg2').show();");
        }
    }

    /**
     * @return the nuevoUsuario
     */
    public Usuario getNuevoUsuario() {
        return nuevoUsuario;
    }

    /**
     * @param nuevoUsuario the nuevoUsuario to set
     */
    public void setNuevoUsuario(Usuario nuevoUsuario) {
        this.nuevoUsuario = nuevoUsuario;
    }

    /**
     * @return the rolMapper
     */
    public RolMapper getRolMapper() {
        return rolMapper;
    }

    /**
     * @param rolMapper the rolMapper to set
     */
    public void setRolMapper(RolMapper rolMapper) {
        this.rolMapper = rolMapper;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the barrio
     */
    public String getBarrio() {
        return barrio;
    }

    /**
     * @param barrio the barrio to set
     */
    public void setBarrio(String barrio) {
        this.barrio = barrio;
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
     * @return the suscripcion
     */
    public String getSuscripcion() {
        return suscripcion;
    }

    /**
     * @param suscripcion the suscripcion to set
     */
    public void setSuscripcion(String suscripcion) {
        this.suscripcion = suscripcion;
    }

}
