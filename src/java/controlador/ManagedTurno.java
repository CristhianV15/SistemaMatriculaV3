/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.TurnoFacadeLocal;
import entidad.Turno;
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
public class ManagedTurno {

    @EJB

    TurnoFacadeLocal turnoFacadeLocal;
    private List<Turno> listarTurno;
    private List<Turno> listarTurno2;
    private Turno turno;

  
    public List<Turno> getListarTurno() {
        listarTurno = turnoFacadeLocal.buscarTurno(turno);
        return listarTurno;
    }
     public List<Turno> getListarTurno2() {
         listarTurno2= turnoFacadeLocal.findAll();
        return listarTurno2;
    }
    
    public void setListarTurno(List<Turno> listarTurno) {
        this.listarTurno = listarTurno;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    @PostConstruct
    public void init() {
        turno = new Turno();
    }

    public void guardarTurno() {
        this.turnoFacadeLocal.create(turno);
    }

    public void eliminarTurno(Turno t) {
        this.turnoFacadeLocal.remove(t);
    }

    public void cargarTurno(Turno t) {
        this.turno = t;
    }

    public void modificarTurno() {
        this.turnoFacadeLocal.edit(turno);
    }

    public void setListarTurno2(List<Turno> listarTurno2) {
        this.listarTurno2 = listarTurno2;
    }
}
