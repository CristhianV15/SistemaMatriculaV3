/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.UsuarioFacadeLocal;
import entidad.Usuario;
import java.io.IOException;
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

/**
 *
 * @author Cristhian
 */

@ManagedBean
@SessionScoped
public class ManagedUsuario2 {
    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;
    private List<Usuario> listarUsuario;
    private Usuario usuario;

    public List<Usuario> getListarUsuario() {
        listarUsuario = usuarioFacadeLocal.findAll();
        return listarUsuario;
    }

    public void setListarUsuario(List<Usuario> listarUsuario) {
        this.listarUsuario = listarUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @PostConstruct
    public void init(){
        this.usuario = new Usuario();
    }
    //Metodos CRUD
     public void guardarUsuario(){
        this.usuarioFacadeLocal.create(usuario);
    }
    public void eliminarUsuario(Usuario c){
         this.usuarioFacadeLocal.remove(c);
    }
  
    public void encontrarUsuario(Usuario c){
        this.usuario=c;
    }
    
    public void modificar(){
        this.usuarioFacadeLocal.edit(usuario);
    }
}
