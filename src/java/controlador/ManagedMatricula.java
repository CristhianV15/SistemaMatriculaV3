/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.MatriculaFacadeLocal;
import entidad.Alumno;
import entidad.Matricula;
import entidad.Salon;
import entidad.Usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class ManagedMatricula {
    MatriculaFacadeLocal matriculaFacadeLocal;
    private List<Matricula> listarMatricula;
    private Matricula matricula;
    private Salon salon;
    private Alumno alumno;
    private Usuario usuario;

    public List<Matricula> getListarMatricula() {
        this.listarMatricula = this.matriculaFacadeLocal.findAll();
        return listarMatricula;
    }

    public void setListarMatricula(List<Matricula> listarMatricula) {
        this.listarMatricula = listarMatricula;
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
        this.salon= new Salon();
        this.alumno= new Alumno();
        this.usuario= new Usuario();
    }
    public void guardarMatricula(){
        this.matricula.setIdSalon(salon);
        this.matricula.setIdAlumno(alumno);
        this.matricula.setIdUsuarioCreado(usuario);
        this.matriculaFacadeLocal.create(matricula);
    }
    public void eliminarMatricula(Matricula m){
         this.matriculaFacadeLocal.remove(m);
    }
  
    public void encontrarMatricula(Matricula m){
        this.salon.setIdSalon(m.getIdSalon().getIdSalon());
        this.alumno.setIdAlumno(m.getIdAlumno().getIdAlumno());
        this.usuario.setIdUsuario(m.getIdUsuarioCreado().getIdUsuario());
        this.matricula= m;
    }
    
    public void modificar(){
        this.matricula.setIdSalon(salon);
        this.matricula.setIdAlumno(alumno);
        this.matricula.setIdUsuarioCreado(usuario);
        this.matriculaFacadeLocal.edit(matricula);
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}