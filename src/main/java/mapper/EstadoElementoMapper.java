/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import entities.Estadoelemento;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author nicol
 */
@Named
@Stateless
public class EstadoElementoMapper extends AbstractMapper<Estadoelemento, Integer>{

    @Override
    public Estadoelemento buscar(Integer id) {
        return em.find(Estadoelemento.class, id);
    }
    
}
