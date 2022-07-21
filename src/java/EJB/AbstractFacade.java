/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entidad.Ciclo;
import entidad.Grado;
import entidad.Matricula;
import entidad.Salon;
import entidad.Seccion;
import entidad.Turno;
import entidad.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Guille
 * @param <T>
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    public List<Usuario> buscarUsuario(Usuario usu){
        String jpql = "Select u from Usuario u where u.email = ?1 and  u.clave = ?2";
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter(1, usu.getEmail());
        query.setParameter(2, usu.getClave());
        return query.getResultList();
    }
    
    //Busqueda ciclo (Solo estado 1)
    public List<Ciclo> buscarCiclo(Ciclo ci){
         String jpql= "SELECT c FROM Ciclo c WHERE c.estado = 1";
         Query query = getEntityManager().createQuery(jpql);
        return query.getResultList();
    }
    
    public List<Grado> buscarGrado(Grado gr){
         String jpql= "SELECT g FROM Grado g WHERE g.estado = 1";
         Query query = getEntityManager().createQuery(jpql);
        return query.getResultList();
    }
    
    public List<Turno> buscarTurno(Turno tu){
         String jpql= "SELECT t FROM Turno t WHERE t.estado = 1";
         Query query = getEntityManager().createQuery(jpql);
        return query.getResultList();
    }
    
    public List<Seccion> buscarSeccion(Seccion se){
         String jpql= "SELECT s FROM Seccion s WHERE s.estado = 1";
         Query query = getEntityManager().createQuery(jpql);
        return query.getResultList();
    }
    
    //Para matricula
     public List<Object[]> listarAlumnos(){
        String jpql = "Select a from Alumno a where a.estado <>0 order by a.apellidoPaterno, a.apellidoMaterno, a.nombres";
        Query query = getEntityManager().createQuery(jpql);
        return query.getResultList();
    }
    public List<Object[]> listarCiclos(){
        String jpql = "Select a from Ciclo a where a.estado <>0 order by a.nombreCiclo";
        Query query = getEntityManager().createQuery(jpql);
        return query.getResultList();
    }
    public List<Object[]> listarSalones(){
        String jpql = "Select a from Salon a where a.estado <>0";
        Query query = getEntityManager().createQuery(jpql);
        return query.getResultList();
    }
    public void matriculaUpdate(Matricula m){
        String jpql = "update matricula set idAlumno=?1 where idMatricula=?2";
        Query query = getEntityManager().createNativeQuery(jpql);
        query.setParameter(1, m.getIdAlumno().getIdAlumno());
        query.setParameter(2, m.getIdMatricula());
        query.executeUpdate();
    }
    
        public Integer validarMatricula(Matricula m){ 
        System.out.print("validarMatricula: " );
        Integer resultado = 0;
        try {
//            String jpql = "select if( (SELECT count(0) from matricula WHERE idSalon=?1) < (SELECT vacantes from salon WHERE idSalon=?2), 1,0) disponible";
            String jpql = "Select a from Matricula a WHERE a.idSalon = ?1";
            
            Query query = getEntityManager().createQuery(jpql);
            query.setParameter(1, m.getIdSalon());
            System.out.print("matriculados: " + jpql);
                        
            List<Matricula> listMatricula = query.getResultList();
            Integer matriculados = listMatricula.size();
            System.out.print("matriculados: " + matriculados);
            
            String jpql2 = "Select a from Salon a WHERE a.idSalon = ?1";
            Query query2 = getEntityManager().createQuery(jpql2);
            query2.setParameter(1, m.getIdSalon().getIdSalon());            
            Salon salon = (Salon) query2.getResultList().get(0);
            Integer vacantes = salon.getVacantes();
            System.out.print("vacantes: " + vacantes);
            if (vacantes > matriculados) {
                resultado = 1;
//                String jpql3 = "update salon set vacantes = vacantes - 1 where idSalon=?1";
//                Query query3 = getEntityManager().createNativeQuery(jpql3);
//                query3.setParameter(1, m.getIdSalon().getIdSalon());
//                query3.executeUpdate();
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return resultado;
    }
}
