/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import entities.Categoria;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author nicol
 */
@Named
@Stateless
public class CategoriaMapper extends AbstractMapper<Categoria, Integer> {

    @Override
    public Categoria buscar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Categoria> getAll() {
        return em.createNamedQuery("Categoria.findAll", Categoria.class).getResultList();
    }
}
