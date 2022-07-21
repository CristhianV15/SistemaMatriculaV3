/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entidad.Ciclo;
import entidad.Grado;
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
}
