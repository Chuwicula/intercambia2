/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import entities.Usuario;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.persistence.Parameter;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author nicol
 */
@Named
@Stateless
public class UsuarioMapper extends AbstractMapper<Usuario, Integer> {

    @Override
    public Usuario buscar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Usuario readByCredentials(String mail, String pass) {
        Usuario retorno = null;
        try {
            TypedQuery<Usuario> queryUsuario = em.createNamedQuery("Usuario.findByPass", Usuario.class);
            queryUsuario.setParameter("mail", mail);
            queryUsuario.setParameter("pass", pass);
            retorno = queryUsuario.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("No se encontró nada");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }

    public boolean validarExistenciaUsuario(String mail) {
        System.out.println("mail:" + mail);
        Query query = em.createNamedQuery("Usuario.findByMail");
        query.setParameter("mail", mail);
        Long counter = (Long) query.getSingleResult();
        System.out.println("Encontré " + counter);
        return counter != 0;

    }

}
