/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import entities.Elemento;
import entities.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.TypedQuery;

/**
 *
 * @author nicol
 */
@Named
@Stateless
public class ElementosMapper extends AbstractMapper<Elemento, Integer> {

    @Override
    public Elemento buscar(Integer id) {
        return em.find(Elemento.class, id);
    }

    public List<Elemento> getElementosDisponibles(Usuario usuario) {
        TypedQuery<Elemento> queryUsuario = em.createNamedQuery(
                "Elemento.findElementosDisponibles", Elemento.class);
        queryUsuario.setParameter("usuario", usuario);
        queryUsuario.setParameter("estado", 1);
        return queryUsuario.getResultList();

    }

    public List<Elemento> getElementosUsuario(Usuario usuario) {
        TypedQuery<Elemento> queryUsuario = em.createNamedQuery(
                "Elemento.findElementosUsuario", Elemento.class);
        queryUsuario.setParameter("usuario", usuario);
        return queryUsuario.getResultList();
    }
}
