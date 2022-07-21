/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.SeccionFacadeLocal;
import entidad.Seccion;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author rolando
 */

@ManagedBean
@SessionScoped
public class ManagedSeccion {
    @EJB
            
    SeccionFacadeLocal seccionFacadeLocal;
    private List<Seccion> listarSeccion;
    private List<Seccion> listarSeccion2;
    private Seccion seccion;



     public List<Seccion> getListarSeccion() {
        listarSeccion = seccionFacadeLocal.buscarSeccion(seccion);
        return listarSeccion;
    }
     public List<Seccion> getListarSeccion2() {
         listarSeccion2= seccionFacadeLocal.findAll();
        return listarSeccion2;
    }

    public void setListarSeccion(List<Seccion> listarSeccion) {
        this.listarSeccion = listarSeccion;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }
    
    @PostConstruct
    public void init(){
        seccion = new Seccion();
    }
    
    public void guardarSeccion(){
        this.seccionFacadeLocal.create(seccion);
    }
    
    public void eliminarSeccion(Seccion s){
        this.seccionFacadeLocal.remove(s);
    }
    
    public void cargarSeccion(Seccion s){
        this.seccion = s;
    }
    
    public void modificarSeccion(){
        this.seccionFacadeLocal.edit(seccion);
    }


    public void setListarSeccion2(List<Seccion> listarSeccion2) {
        this.listarSeccion2 = listarSeccion2;
    }
}
