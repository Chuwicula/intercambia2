/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import entities.Solicitud;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author nicol
 */
@Named
@Stateless
public class SolicitudMapper extends AbstractMapper<Solicitud , Integer> {

    @Override
    public Solicitud buscar(Integer id) {
        return em.find(Solicitud.class, id);
    }

}
