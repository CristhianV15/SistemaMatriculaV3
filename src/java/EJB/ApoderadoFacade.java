/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entidad.Apoderado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Guille
 */
@Stateless
public class ApoderadoFacade extends AbstractFacade<Apoderado> implements ApoderadoFacadeLocal {

    @PersistenceContext(unitName = "MatriculaV3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApoderadoFacade() {
        super(Apoderado.class);
    }
    
}
