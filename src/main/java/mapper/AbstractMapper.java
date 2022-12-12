/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nicol
 * @param <T>
 * @param <K>
 */
public abstract class AbstractMapper<T, K> {

    @PersistenceContext(unitName = "my_persistence_unit")
    protected EntityManager em;

    public abstract T buscar(K id);

    public T crear(T object) {
        em.persist(object);
        em.flush();
        em.refresh(object);
        return object;
    }

    public T actualizar(T object) {
        return (T) em.merge(object);
    }

    public void eliminar(T object) {

        T objectReturn = (T) em.merge(object);
        em.remove(object);

    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

}
