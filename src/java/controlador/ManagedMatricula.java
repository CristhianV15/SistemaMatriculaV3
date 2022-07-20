package controlador;

import EJB.MatriculaFacadeLocal;
import entidad.Alumno;
import entidad.Matricula;
import entidad.Salon;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@SessionScoped
public class ManagedMatricula {
    @EJB
    MatriculaFacadeLocal matriculaFacadeLocal;
    private List<Matricula> listarMatricula;
    private Matricula matricula;
    String verPagina;
    private List<Object[]> listarAlumnos;
    private List<Object[]> listarSalones;
    private Salon salon;
    private Alumno alumno;

    public List<Matricula> getListarMatricula() {
        return listarMatricula;
    }

    public void setListarMatricula(List<Matricula> listarMatricula) {
        this.listarMatricula = listarMatricula;
    }

    public List<Object[]> getListarAlumnos() {
        listarAlumnos = matriculaFacadeLocal.listarAlumnos();        
        return listarAlumnos;
    }

    public void setListarAlumnos(List<Object[]> listarAlumnos) {
        this.listarAlumnos = listarAlumnos;
    }
    

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
    
    @PostConstruct
    public void init(){
        this.matricula = new Matricula();
        this.salon = new Salon();
        this.alumno = new Alumno();
    }
    public void guardarMatricula(){
//        matricula.setIdSalon(salon);
//        matricula.setIdAlumno(alumno);
        this.matriculaFacadeLocal.create(matricula);
    }
    public void eliminarMatricula(Matricula a){
         this.matriculaFacadeLocal.remove(a);
    }
  
    public void encontrarMatricula(Matricula a){
        this.matricula=a;
    }
    
    public void modificar(){
        this.matriculaFacadeLocal.edit(matricula);
    }
    
    public String validarMatricula(){
//        listarMatricula = matriculaFacadeLocal.buscarMatricula(matricula);
//        if(!listarMatricula.isEmpty()){
//            //se crea session
//            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user",matricula);
//            verPagina = "/inicio/list.xhtml";
//        }
//        else{
//            FacesMessage mensaje = new FacesMessage("Matricula o contraseña invalido");
//            FacesContext.getCurrentInstance().addMessage(null, mensaje);
//        }
        return verPagina;
    }
//    public List<Alumno> listarAlumnos(){
//        
//        listarAlumnos = matriculaFacadeLocal.listarAlumnos();
//        System.out.println("listarAlumnos size: " + listarAlumnos.size()); 
//        return listarAlumnos;
//    }

    public List<Object[]> getListarSalones() {
        listarSalones = matriculaFacadeLocal.listarSalones();
        return listarSalones;
    }

    public void setListarSalones(List<Object[]> listarSalones) {
        this.listarSalones = listarSalones;
    }

}
