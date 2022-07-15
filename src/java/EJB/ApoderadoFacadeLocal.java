/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entidad.Apoderado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Guille
 */
@Local
public interface ApoderadoFacadeLocal {

    void create(Apoderado apoderado);

    void edit(Apoderado apoderado);

    void remove(Apoderado apoderado);

    Apoderado find(Object id);

    List<Apoderado> findAll();

    List<Apoderado> findRange(int[] range);

    int count();
    
}
