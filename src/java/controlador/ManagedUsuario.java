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

@ManagedBean
@SessionScoped
public class ManagedUsuario {
    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;
    private List<Usuario> listarUsuario;
    private Usuario usuario;
    String verPagina;

    public List<Usuario> getListarUsuario() {
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
    
    public String validarUsuario(){
        listarUsuario = usuarioFacadeLocal.buscarUsuario(usuario);
        if(!listarUsuario.isEmpty()){
            //se crea session
            usuario.setTipo(listarUsuario.get(0).getTipo());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user",usuario);
            verPagina = "/inicio/list.xhtml";
        }
        else{
            FacesMessage mensaje = new FacesMessage("Usuario o contraseña invalido");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        return verPagina;
    }
    
    public void obtenerSesion(){
        usuario = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        if(usuario == null){
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                ec.redirect(ec.getRequestContextPath() + "/faces/logueo.xhtml");
//                FacesContext.getCurrentInstance().getExternalContext().redirect("/Semana6_JSF_CRUD/faces/logueo.xhtml");
                init();
            } catch (IOException ex) {
                Logger.getLogger(ManagedUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    public void cambiarIdioma(ValueChangeEvent e){
        FacesContext fc = FacesContext.getCurrentInstance();
        UIViewRoot ui = fc.getViewRoot();
        ui.setLocale(new Locale(e.getNewValue().toString()));
    }
    
}
