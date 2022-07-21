/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
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
@Table(name = "grado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grado.findAll", query = "SELECT g FROM Grado g")
    , @NamedQuery(name = "Grado.findByIdGrado", query = "SELECT g FROM Grado g WHERE g.idGrado = :idGrado")
    , @NamedQuery(name = "Grado.findByNombreGrado", query = "SELECT g FROM Grado g WHERE g.nombreGrado = :nombreGrado")
    , @NamedQuery(name = "Grado.findByNivel", query = "SELECT g FROM Grado g WHERE g.nivel = :nivel")
    , @NamedQuery(name = "Grado.findByRotulo", query = "SELECT g FROM Grado g WHERE g.rotulo = :rotulo")
    , @NamedQuery(name = "Grado.findByEstado", query = "SELECT g FROM Grado g WHERE g.estado = :estado")
    , @NamedQuery(name = "Grado.findByCreado", query = "SELECT g FROM Grado g WHERE g.creado = :creado")})
public class Grado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGrado")
    private Integer idGrado;
    @Size(max = 45)
    @Column(name = "nombreGrado")
    private String nombreGrado;
    @Size(max = 10)
    @Column(name = "nivel")
    private String nivel;
    @Column(name = "rotulo")
    private Integer rotulo;
    @Column(name = "estado")
    private Integer estado;
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrado")
    private Collection<Salon> salonCollection;

    public Grado() {
        estado=1;
        creado= new Date();
    }

    public Grado(Integer idGrado) {
        this.idGrado = idGrado;
    }

    public Integer getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Integer idGrado) {
        this.idGrado = idGrado;
    }

    public String getNombreGrado() {
        return nombreGrado;
    }

    public void setNombreGrado(String nombreGrado) {
        this.nombreGrado = nombreGrado;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Integer getRotulo() {
        return rotulo;
    }

    public void setRotulo(Integer rotulo) {
        this.rotulo = rotulo;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    @XmlTransient
    public Collection<Salon> getSalonCollection() {
        return salonCollection;
    }

    public void setSalonCollection(Collection<Salon> salonCollection) {
        this.salonCollection = salonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrado != null ? idGrado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grado)) {
            return false;
        }
        Grado other = (Grado) object;
        if ((this.idGrado == null && other.idGrado != null) || (this.idGrado != null && !this.idGrado.equals(other.idGrado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Grado[ idGrado=" + idGrado + " ]";
    }
    
}
