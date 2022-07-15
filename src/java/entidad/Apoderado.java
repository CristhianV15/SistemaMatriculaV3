/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Guille
 */
@Entity
@Table(name = "apoderado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apoderado.findAll", query = "SELECT a FROM Apoderado a")
    , @NamedQuery(name = "Apoderado.findByIdApoderado", query = "SELECT a FROM Apoderado a WHERE a.idApoderado = :idApoderado")
    , @NamedQuery(name = "Apoderado.findByNombres", query = "SELECT a FROM Apoderado a WHERE a.nombres = :nombres")
    , @NamedQuery(name = "Apoderado.findByApellidoPaterno", query = "SELECT a FROM Apoderado a WHERE a.apellidoPaterno = :apellidoPaterno")
    , @NamedQuery(name = "Apoderado.findByApellidoMaterno", query = "SELECT a FROM Apoderado a WHERE a.apellidoMaterno = :apellidoMaterno")
    , @NamedQuery(name = "Apoderado.findByTipoDocumento", query = "SELECT a FROM Apoderado a WHERE a.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "Apoderado.findByNumeroDocumento", query = "SELECT a FROM Apoderado a WHERE a.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "Apoderado.findByEmail", query = "SELECT a FROM Apoderado a WHERE a.email = :email")
    , @NamedQuery(name = "Apoderado.findByCelular", query = "SELECT a FROM Apoderado a WHERE a.celular = :celular")
    , @NamedQuery(name = "Apoderado.findByDireccion", query = "SELECT a FROM Apoderado a WHERE a.direccion = :direccion")
    , @NamedQuery(name = "Apoderado.findByEstado", query = "SELECT a FROM Apoderado a WHERE a.estado = :estado")
    , @NamedQuery(name = "Apoderado.findByCreado", query = "SELECT a FROM Apoderado a WHERE a.creado = :creado")
    , @NamedQuery(name = "Apoderado.findByModificado", query = "SELECT a FROM Apoderado a WHERE a.modificado = :modificado")})
public class Apoderado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idApoderado")
    private Integer idApoderado;
    @Size(max = 50)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 50)
    @Column(name = "apellidoPaterno")
    private String apellidoPaterno;
    @Size(max = 50)
    @Column(name = "apellidoMaterno")
    private String apellidoMaterno;
    @Size(max = 10)
    @Column(name = "tipoDocumento")
    private String tipoDocumento;
    @Size(max = 20)
    @Column(name = "numeroDocumento")
    private String numeroDocumento;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 60)
    @Column(name = "email")
    private String email;
    @Size(max = 20)
    @Column(name = "celular")
    private String celular;
    @Size(max = 250)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "estado")
    private Integer estado;
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @Column(name = "modificado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idApoderado")
    private Collection<Alumno> alumnoCollection;

    public Apoderado() {
        estado= 1;
        creado = new Date();
    }

    public Apoderado(Integer idApoderado) {
        this.idApoderado = idApoderado;
    }

    public Integer getIdApoderado() {
        return idApoderado;
    }

    public void setIdApoderado(Integer idApoderado) {
        this.idApoderado = idApoderado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado =1;
    }

    public Timestamp getCreado() {
        return (Timestamp) this.creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }
    public String getCreadoString(){
        return new SimpleDateFormat("dd/MM/yyyy KK:mm a").format(this.creado);
    }
    
    public Date getModificado() {
        return modificado;
    }

    public void setModificado(Date modificado) {
        this.modificado = modificado;
    }

    @XmlTransient
    public Collection<Alumno> getAlumnoCollection() {
        return alumnoCollection;
    }

    public void setAlumnoCollection(Collection<Alumno> alumnoCollection) {
        this.alumnoCollection = alumnoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApoderado != null ? idApoderado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apoderado)) {
            return false;
        }
        Apoderado other = (Apoderado) object;
        if ((this.idApoderado == null && other.idApoderado != null) || (this.idApoderado != null && !this.idApoderado.equals(other.idApoderado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Apoderado[ idApoderado=" + idApoderado + " ]";
    }
    
}
