/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entities.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import mapper.UsuarioMapper;
import sesion.AdministradorSesion;

/**
 *
 * @author nicol
 */
@Named(value = "inicioBean")
@RequestScoped
public class InicioBean {

    private String mail;

    private String pass;

    @Inject
    AdministradorSesion sessionBean;

    @Inject
    UsuarioMapper usuarioMapper;

    public void iniciarSesion() {        
        Usuario user = usuarioMapper.buscarPorCredenciales(mail, pass);
        if (user != null) {            
            sessionBean.setUsuario(user);
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(
                        validarRol(user));
            } catch (IOException ex) {
                System.out.println("Error en contexto de aplicación");
            }

        }
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario o contraseña incorrectas"));

    }

    public String validarRol(Usuario usuario) {
        String rootPath = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()+"/faces";
        switch (usuario.getIdrol().getNombrerol().toLowerCase()) {
            case "trocador":
                return rootPath + "/modulos/trocador/disponibles.xhtml?faces-redirect=true";
            case "admin":
                    return rootPath + "/modulos/admin/disponibles.xhtml?faces-redirect=true";
            case "operador":
                return rootPath + "/modulos/logistico/disponibles.xhtml?faces-redirect=true";
            default:
                return rootPath;
        }
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
}
