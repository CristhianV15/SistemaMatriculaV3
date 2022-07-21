/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import EJB.GradoFacadeLocal;
import entidad.Grado;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ManagedGrado {
    @EJB
    GradoFacadeLocal gradoFacadeLocal;
    private List<Grado> listarGrado;
    private List<Grado> listarGrado2;
    private Grado grado; 

   public List<Grado> getListarGrado() {
        listarGrado = gradoFacadeLocal.buscarGrado(grado);
        return listarGrado;
    }
     public List<Grado> getListarGrado2() {
         listarGrado2= gradoFacadeLocal.findAll();
        return listarGrado2;
    }
//    public List<Grado> getListarGrado() {
//        listarGrado = gradoFacadeLocal.buscarGradoEstado(grado);
//        return listarGrado;
//    }
    public void setListarGrado(List<Grado> listarGrado) {
        this.listarGrado = listarGrado;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }
    
    @PostConstruct
    public void init(){
        grado= new Grado();
    }
    public void guardarGrado(){
        this.gradoFacadeLocal.create(grado);
    }
    public void eliminarGrado(Grado g){
         this.gradoFacadeLocal.remove(g);
    }
  
    public void encontrarGrado (Grado g){
        this.grado=g ;
    }
    
    public void modificar(){
        this.gradoFacadeLocal.edit(grado);
    }

  

    public void setListarGrado2(List<Grado> listarGrado2) {
        this.listarGrado2 = listarGrado2;
    }

  
}
