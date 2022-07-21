package controlador;

import EJB.MatriculaFacadeLocal;

import entidad.Alumno;
import entidad.Matricula;
import entidad.Salon;
import entidad.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    private Usuario usuarioCreado;
    private Usuario usuarioModificado;
    
    public List<Matricula> getListarMatricula() {
        
        listarMatricula = this.matriculaFacadeLocal.findAll();
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
        Usuario usuarioSession = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        this.matricula = new Matricula();
        this.alumno = new Alumno();
        this.salon = new Salon();
        this.usuarioCreado = usuarioSession;
        this.usuarioModificado = usuarioSession;
        
    }
    public void guardarMatricula(){        
        this.matricula.setIdAlumno(alumno);
        this.matricula.setIdSalon(salon);
        this.matricula.setIdUsuarioCreado(usuarioCreado);
        this.matricula.setIdUsuarioModificado(usuarioModificado);
        this.matricula.setCreado(Timestamp.valueOf(LocalDateTime.now()));
        this.matriculaFacadeLocal.create(matricula);
    }
    public void eliminarMatricula(Matricula a){
         this.matriculaFacadeLocal.remove(a);
    }

    public void encontrarMatricula(Matricula a){
        this.alumno.setIdAlumno(a.getIdAlumno().getIdAlumno());
        this.salon.setIdSalon(a.getIdSalon().getIdSalon());         
        this.usuarioCreado.setIdUsuario(a.getIdUsuarioCreado().getIdUsuario());
        this.usuarioModificado.setIdUsuario(a.getIdUsuarioModificado().getIdUsuario());
//        this.alumno = a.getIdAlumno();
//        this.salon = a.getIdSalon();
//        this.matricula.setIdAlumno(alumno);
//        this.matricula.setIdSalon(salon);
//        this.matricula.setIdUsuarioCreado(a.getIdUsuarioCreado());
        this.matricula=a;
        
    }
    
    public void modificar(){
//        System.out.println("modificar alumno id: "+ alumno.getIdAlumno());
//        System.out.println("modificar alumno id: "+ matricula.getIdAlumno().getIdAlumno());
        this.matricula.setIdAlumno(alumno);
        this.matricula.setIdSalon(salon);        
        this.matricula.setIdUsuarioCreado(usuarioCreado);
        this.matricula.setIdUsuarioModificado(usuarioModificado);
//        this.matricula.setIdUsuarioModificado(usuarioModificado);        
        this.matricula.setModificado(Timestamp.valueOf(LocalDateTime.now()));
//        this.matricula.setModificado(Timestamp.valueOf(LocalDateTime.now()));
        this.matriculaFacadeLocal.edit(matricula);
    }

    public List<Object[]> getListarSalones() {
        listarSalones = matriculaFacadeLocal.listarSalones();
        return listarSalones;
    }

    public void setListarSalones(List<Object[]> listarSalones) {
        this.listarSalones = listarSalones;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Usuario getUsuarioCreado() {
        return usuarioCreado;
    }

    public void setUsuarioCreado(Usuario usuarioCreado) {
        this.usuarioCreado = usuarioCreado;
    }

    public Usuario getUsuarioModificado() {
        return usuarioModificado;
    }

    public void setUsuarioModificado(Usuario usuarioModificado) {
        this.usuarioModificado = usuarioModificado;
    }

}
