/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entidad.Turno;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Guille
 */
@Local
public interface TurnoFacadeLocal {

    void create(Turno turno);

    void edit(Turno turno);

    void remove(Turno turno);

    Turno find(Object id);

    List<Turno> findAll();

    List<Turno> findRange(int[] range);

    int count();
    
}
