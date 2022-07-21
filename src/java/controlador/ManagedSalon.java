/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import EJB.SalonFacadeLocal;
import entidad.Ciclo;
import entidad.Grado;
import entidad.Salon;
import entidad.Seccion;
import entidad.Turno;
import entidad.Usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class ManagedSalon {
    @EJB
    private SalonFacadeLocal salonFacadeLocal;
    private List<Salon> listarSalon;
    private Salon salon;
    private Ciclo ciclo;
    private Grado grado;
    private Turno turno;
    private Seccion seccion;
    private Usuario usuarioCreador;
    private Usuario usuarioModificador;
    
    public List<Salon> getListarSalon() {
        listarSalon= salonFacadeLocal.findAll();
        return listarSalon;
    }

    public void setListarSalon(List<Salon> listarSalon) {
        this.listarSalon = listarSalon;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }
    @PostConstruct
    public void init(){
        this.salon= new Salon();
        this.ciclo= new Ciclo();
        this.grado= new Grado();
        this.turno= new Turno();
        this.seccion= new Seccion();
        this.usuarioCreador= new Usuario();
        this.usuarioModificador= new Usuario();
    }
    public void guardarSalon(){
        this.salon.setIdCiclo(ciclo);
        this.salon.setIdGrado(grado);
        this.salon.setIdTurno(turno);
        this.salon.setIdSeccion(seccion);
        this.salon.setIdUsuarioCreado(usuarioCreador);
        this.salon.setIdUsuarioModificado(usuarioModificador);
        this.salonFacadeLocal.create(salon);
    }
    public void eliminarSalon(Salon s){
         this.salonFacadeLocal.remove(s);
    }
  
    public void encontrarSalon(Salon s){
        this.ciclo.setIdCiclo(s.getIdCiclo().getIdCiclo());
        this.grado.setIdGrado(s.getIdGrado().getIdGrado());
        this.turno.setIdTurno(s.getIdTurno().getIdTurno());
        this.seccion.setIdSeccion(s.getIdSeccion().getIdSeccion());
        this.usuarioCreador.setIdUsuario(s.getIdUsuarioCreado().getIdUsuario());
        this.salon=s;
    }
    
    public void modificar(){
        this.salon.setIdCiclo(ciclo);
        this.salon.setIdGrado(grado);
        this.salon.setIdTurno(turno);
        this.salon.setIdSeccion(seccion);
        this.salon.setIdUsuarioCreado(usuarioCreador);
        this.salon.setIdUsuarioModificado(usuarioModificador);
      //  this.salonFacadeLocal.create(salon);
        this.salonFacadeLocal.edit(salon);
    }

    public SalonFacadeLocal getSalonFacadeLocal() {
        return salonFacadeLocal;
    }

    public void setSalonFacadeLocal(SalonFacadeLocal salonFacadeLocal) {
        this.salonFacadeLocal = salonFacadeLocal;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Usuario getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(Usuario usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public Usuario getUsuarioModificador() {
        return usuarioModificador;
    }

    public void setUsuarioModificador(Usuario usuarioModificador) {
        this.usuarioModificador = usuarioModificador;
    }
    
}
