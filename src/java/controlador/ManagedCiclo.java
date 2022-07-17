/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.CicloFacadeLocal;
import entidad.Ciclo;
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
public class ManagedCiclo {
    @EJB
    CicloFacadeLocal cicloFacadeLocal;
    private List<Ciclo> listarCiclo;
    private Ciclo ciclo;
    
     public List<Ciclo> getListarCiclo() {
        listarCiclo = cicloFacadeLocal.findAll();
        return listarCiclo;
    }
    
    public List<Ciclo> getListarCicloPorEstado(){
       listarCiclo= cicloFacadeLocal.findByEstado();
       return listarCiclo;
    }
    public void setListarCiclo(List<Ciclo> listarCiclo) {
        this.listarCiclo = listarCiclo;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }
    
    @PostConstruct
    public void init(){
        ciclo= new Ciclo();
    }
    public void guardarCiclo(){
        this.cicloFacadeLocal.create(ciclo);
    }
    public void eliminarCiclo(Ciclo c){
         this.cicloFacadeLocal.remove(c);
    }
  
    public void encontrarCiclo(Ciclo c){
        this.ciclo=c;
    }
    
    public void modificar(){
        this.cicloFacadeLocal.edit(ciclo);
    }
}
