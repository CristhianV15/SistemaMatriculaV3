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
@Table(name = "turno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turno.findAll", query = "SELECT t FROM Turno t")
    , @NamedQuery(name = "Turno.findByIdTurno", query = "SELECT t FROM Turno t WHERE t.idTurno = :idTurno")
    , @NamedQuery(name = "Turno.findByNombreTurno", query = "SELECT t FROM Turno t WHERE t.nombreTurno = :nombreTurno")
    , @NamedQuery(name = "Turno.findByEstado", query = "SELECT t FROM Turno t WHERE t.estado = :estado")
    , @NamedQuery(name = "Turno.findByCreado", query = "SELECT t FROM Turno t WHERE t.creado = :creado")})
public class Turno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTurno")
    private Integer idTurno;
    @Size(max = 45)
    @Column(name = "nombreTurno")
    private String nombreTurno;
    @Column(name = "estado")
    private Integer estado;
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTurno")
    private Collection<Salon> salonCollection;

    public Turno() {
    }

    public Turno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public Integer getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public String getNombreTurno() {
        return nombreTurno;
    }

    public void setNombreTurno(String nombreTurno) {
        this.nombreTurno = nombreTurno;
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
        hash += (idTurno != null ? idTurno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turno)) {
            return false;
        }
        Turno other = (Turno) object;
        if ((this.idTurno == null && other.idTurno != null) || (this.idTurno != null && !this.idTurno.equals(other.idTurno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Turno[ idTurno=" + idTurno + " ]";
    }
    
}
