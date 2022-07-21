/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.AlumnoFacadeLocal;
import entidad.Alumno;
import entidad.Apoderado;
import entidad.Usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Cristhian
 */
@ManagedBean
@SessionScoped
public class ManagedAlumno {
    @EJB
    private AlumnoFacadeLocal alumnoFacadeLocal;
    private List<Alumno> listarAlumno;
    private Apoderado apoderado;
    private Usuario usuario;
    private Alumno alumno;

    public List<Alumno> getListarAlumno() {
        listarAlumno = alumnoFacadeLocal.findAll();
        return listarAlumno;
    }

    public void setListarAlumno(List<Alumno> listarAlumno) {
        this.listarAlumno = listarAlumno;
    }

    public Apoderado getApoderado() {
        return apoderado;
    }

    public void setApoderado(Apoderado apoderado) {
        this.apoderado = apoderado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
     @PostConstruct
    public void init(){
        this.alumno= new Alumno();
        this.usuario= new Usuario();
        this.apoderado= new Apoderado();
    }
    
    //Metodos CRUD
    public void guardarAlumno(){
        this.alumno.setIdApoderado(apoderado);
        this.alumno.setIdUsuarioCreado(usuario);
        this.alumnoFacadeLocal.create(alumno);
    }
    public void eliminarAlumno(Alumno a){
         this.alumnoFacadeLocal.remove(a);
    }
  
    public void encontrarAlumno(Alumno a){
        this.apoderado.setIdApoderado(a.getIdApoderado().getIdApoderado());
        this.usuario.setIdUsuario(a.getIdUsuarioCreado().getIdUsuario());
        this.alumno= a;
    }
    
    public void modificar(){
        this.alumno.setIdApoderado(apoderado);
        this.alumno.setIdUsuarioCreado(usuario);
        this.alumno.setIdUsuarioCreado(usuario);
        this.alumnoFacadeLocal.edit(alumno);
    }

}
