/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entities.Usuario;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import mapper.UsuarioMapper;
import utilidad.ServicioCorreo;

/**
 *
 * @author nicol
 */
@Named(value = "olvidarBean")
@RequestScoped
public class OlvidarContrasenaBean {

    @Inject
    UsuarioMapper usuarioMapper;

    private String correoUsuario;

    public void enviarCorreo() {

        if (usuarioMapper.validarExistenciaUsuario(correoUsuario)) {
            //enviar notificacion
            Set<String> emails = new HashSet<>();
            emails.add(correoUsuario);
            ServicioCorreo.enviarNotificacion(emails, "Recuperar Contraseña", "");
        }

    }

    /**
     * @return the correoUsuario
     */
    public String getCorreoUsuario() {
        return correoUsuario;
    }

    /**
     * @param correoUsuario the correoUsuario to set
     */
    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

}
