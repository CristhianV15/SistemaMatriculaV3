/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entidad.Ciclo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Guille
 */
@Stateless
public class CicloFacade extends AbstractFacade<Ciclo> implements CicloFacadeLocal {

    @PersistenceContext(unitName = "MatriculaV3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CicloFacade() {
        super(Ciclo.class);
    }
    
}
