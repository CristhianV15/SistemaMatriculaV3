/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.ApoderadoFacadeLocal;
import entidad.Apoderado;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

/**
 *
 * @author Cristhian
 */
public class ManagedApoderado {
    @EJB
    ApoderadoFacadeLocal apoderadoFacadeLocal;
    private List<Apoderado> listarApoderado;
    private Apoderado apoderado;

    public List<Apoderado> getListarApoderado() {
        listarApoderado = apoderadoFacadeLocal.findAll();
        return listarApoderado;
    }

    public void setListarApoderado(List<Apoderado> listarApoderado) {
        this.listarApoderado = listarApoderado;
    }

    public Apoderado getApoderado() {
        return apoderado;
    }

    public void setApoderado(Apoderado apoderado) {
        this.apoderado = apoderado;
    }
    
    @PostConstruct
    public void init(){
        apoderado= new Apoderado();
    }
    public void guardarApoderado(){
        this.apoderadoFacadeLocal.create(apoderado);
    }
    public void eliminarApoderado(Apoderado a){
         this.apoderadoFacadeLocal.remove(a);
    }
  
    public void encontrarApoderado(Apoderado a){
        this.apoderado=a;
    }
    
    public void modificar(){
        this.apoderadoFacadeLocal.edit(apoderado);
    }
    
}
