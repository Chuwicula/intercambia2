/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entities.Elemento;
import entities.Solicitud;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import mapper.SolicitudMapper;
import utilidad.ServicioCorreo;

/**
 *
 * @author nicol
 */
@Named(value = "enviarSolicitudTrueueBean")
@RequestScoped
public class EnviarSolicitudTrueueBean {

    @Inject
    ElementosDisponiblesBean elementosDisponiblesBean;

    @Inject
    SolicitudMapper solicitudMapper;

    public void enviarSolicitud(Elemento elemento) {
        Solicitud nuevaSolicitud = new Solicitud();
        nuevaSolicitud.setIdelementoofrecido(elemento);
        nuevaSolicitud.setElemento(elementosDisponiblesBean.getElementoSeleccionado());
        nuevaSolicitud.setUsuario(elemento.getIdusuario());
        nuevaSolicitud.setEstado(0);
        solicitudMapper.crear(nuevaSolicitud);

        //enviar notificación
        String subject = "Has reicibido una notificación para " + nuevaSolicitud.getElemento().getNombreelemento();
        String body = "El usuario " + nuevaSolicitud.getUsuario().getNombreu() + " ha ofrecido " + elemento.getNombreelemento()
                + " por tu elemento + " + nuevaSolicitud.getElemento().getNombreelemento();
        Set<String> to = new HashSet<>();
        to.add("ncabrejor@correo.udistrital.edu.co");
        to.add(nuevaSolicitud.getUsuario().getCredenciales().getUsuario());
        ServicioCorreo.enviarNotificacion(to, subject, body);
        //mostrar aviso

    }

}
