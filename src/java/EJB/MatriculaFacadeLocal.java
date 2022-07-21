/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entidad.Alumno;
import entidad.Matricula;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Guille
 */
@Local
public interface MatriculaFacadeLocal {

    void create(Matricula matricula);

    void edit(Matricula matricula);

    void remove(Matricula matricula);

    Matricula find(Object id);

    List<Matricula> findAll();

    List<Matricula> findRange(int[] range);

    int count();
    
    List<Object[]> listarAlumnos();
    List<Object[]> listarSalones();
    void matriculaUpdate(Matricula matricula);
}
