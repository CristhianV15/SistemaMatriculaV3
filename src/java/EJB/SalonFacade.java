/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entidad.Salon;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Guille
 */
@Stateless
public class SalonFacade extends AbstractFacade<Salon> implements SalonFacadeLocal {

    @PersistenceContext(unitName = "MatriculaV3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SalonFacade() {
        super(Salon.class);
    }
    
}
