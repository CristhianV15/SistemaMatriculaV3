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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Guille
 */
@Entity
@Table(name = "salon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salon.findAll", query = "SELECT s FROM Salon s")
    , @NamedQuery(name = "Salon.findByIdSalon", query = "SELECT s FROM Salon s WHERE s.idSalon = :idSalon")
    , @NamedQuery(name = "Salon.findByVacantes", query = "SELECT s FROM Salon s WHERE s.vacantes = :vacantes")
    , @NamedQuery(name = "Salon.findByEstado", query = "SELECT s FROM Salon s WHERE s.estado = :estado")
    , @NamedQuery(name = "Salon.findByCreado", query = "SELECT s FROM Salon s WHERE s.creado = :creado")
    , @NamedQuery(name = "Salon.findByModificado", query = "SELECT s FROM Salon s WHERE s.modificado = :modificado")})
public class Salon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSalon")
    private Integer idSalon;
    @Column(name = "vacantes")
    private Integer vacantes;
    @Column(name = "estado")
    private Integer estado;
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @Column(name = "modificado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSalon")
    private Collection<Matricula> matriculaCollection;
    @JoinColumn(name = "idCiclo", referencedColumnName = "idCiclo")
    @ManyToOne(optional = false)
    private Ciclo idCiclo;
    @JoinColumn(name = "idGrado", referencedColumnName = "idGrado")
    @ManyToOne(optional = false)
    private Grado idGrado;
    @JoinColumn(name = "idSeccion", referencedColumnName = "idSeccion")
    @ManyToOne(optional = false)
    private Seccion idSeccion;
    @JoinColumn(name = "idTurno", referencedColumnName = "idTurno")
    @ManyToOne(optional = false)
    private Turno idTurno;
    @JoinColumn(name = "idUsuarioCreado", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioCreado;
    @JoinColumn(name = "idUsuarioModificado", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuario idUsuarioModificado;

    public Salon() {
        estado = 1;
        creado = new Date();
    }

    public Salon(Integer idSalon) {
        this.idSalon = idSalon;
    }

    public Integer getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(Integer idSalon) {
        this.idSalon = idSalon;
    }

    public Integer getVacantes() {
        return vacantes;
    }

    public void setVacantes(Integer vacantes) {
        this.vacantes = vacantes;
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

    public Date getModificado() {
        return modificado;
    }

    public void setModificado(Date modificado) {
        this.modificado = modificado;
    }

    @XmlTransient
    public Collection<Matricula> getMatriculaCollection() {
        return matriculaCollection;
    }

    public void setMatriculaCollection(Collection<Matricula> matriculaCollection) {
        this.matriculaCollection = matriculaCollection;
    }

    public Ciclo getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Ciclo idCiclo) {
        this.idCiclo = idCiclo;
    }

    public Grado getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Grado idGrado) {
        this.idGrado = idGrado;
    }

    public Seccion getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Seccion idSeccion) {
        this.idSeccion = idSeccion;
    }

    public Turno getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Turno idTurno) {
        this.idTurno = idTurno;
    }

    public Usuario getIdUsuarioCreado() {
        return idUsuarioCreado;
    }

    public void setIdUsuarioCreado(Usuario idUsuarioCreado) {
        this.idUsuarioCreado = idUsuarioCreado;
    }

    public Usuario getIdUsuarioModificado() {
        return idUsuarioModificado;
    }

    public void setIdUsuarioModificado(Usuario idUsuarioModificado) {
        this.idUsuarioModificado = idUsuarioModificado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSalon != null ? idSalon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salon)) {
            return false;
        }
        Salon other = (Salon) object;
        if ((this.idSalon == null && other.idSalon != null) || (this.idSalon != null && !this.idSalon.equals(other.idSalon))) {
            return false;
        }
        return true;
    }

    public String getNombreSalon() {
        String nombre = "";
        nombre = this.getIdCiclo().getNombreCiclo();
        nombre += " | " + this.getIdGrado().getNombreGrado();
        nombre += " | " + this.getIdTurno().getNombreTurno();
        nombre += " | " + this.getIdSeccion().getNombreSeccion();
        return nombre;
    }

    @Override
    public String toString() {
        return "entidad.Salon[ idSalon=" + idSalon + " ]";
    }

}
