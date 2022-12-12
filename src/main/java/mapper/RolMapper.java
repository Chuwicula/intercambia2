/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import entities.Rol;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nicol
 */
@Named
@Stateless
public class RolMapper {
    
    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public Rol buscar(Integer id) {
        em.flush();
        return em.find(Rol.class, id);
    }
    
    public List<Rol> obtenerRoles(){
        return em.createNamedQuery("Rol.findAll").getResultList();
    }

}
