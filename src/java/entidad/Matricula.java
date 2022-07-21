/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import modelo.util.DbEstado;

/**
 *
 * @author Guille
 */
@Entity
@Table(name = "matricula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", 
            query = "SELECT m FROM Matricula m "
                    + "INNER JOIN m.idAlumno m2 "
                    + "INNER JOIN m.idSalon m3 "
                    + "INNER JOIN m.idUsuarioCreado m4 "
                    + "WHERE m.estado <> 0 order by m.creado desc")
    , @NamedQuery(name = "Matricula.findByIdMatricula", query = "SELECT m FROM Matricula m WHERE m.idMatricula = :idMatricula")
    , @NamedQuery(name = "Matricula.findByEstado", query = "SELECT m FROM Matricula m WHERE m.estado = :estado")
    , @NamedQuery(name = "Matricula.findByCodigoPago", query = "SELECT m FROM Matricula m WHERE m.codigoPago = :codigoPago")
    , @NamedQuery(name = "Matricula.findByFechaPago", query = "SELECT m FROM Matricula m WHERE m.fechaPago = :fechaPago")
    , @NamedQuery(name = "Matricula.findByEstadoPago", query = "SELECT m FROM Matricula m WHERE m.estadoPago = :estadoPago")
    , @NamedQuery(name = "Matricula.findByCreado", query = "SELECT m FROM Matricula m WHERE m.creado = :creado")
    , @NamedQuery(name = "Matricula.findByModificado", query = "SELECT m FROM Matricula m WHERE m.modificado = :modificado")})
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMatricula")
    private Integer idMatricula;
    @Column(name = "estado")
    private Integer estado;
    @Size(max = 45)
    @Column(name = "codigoPago")
    private String codigoPago;
    @Column(name = "fechaPago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;
    @Column(name = "estadoPago")
    private Integer estadoPago;
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @Column(name = "modificado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificado;
    @JoinColumn(name = "idAlumno", referencedColumnName = "idAlumno")
    @ManyToOne(optional = false)
    private Alumno idAlumno;
    @JoinColumn(name = "idSalon", referencedColumnName = "idSalon")
    @ManyToOne(optional = false)
    private Salon idSalon;
    @JoinColumn(name = "idUsuarioCreado", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioCreado;
    @JoinColumn(name = "idUsuarioModificado", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuario idUsuarioModificado;    

    public Matricula() {
    }

    public Matricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Integer getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getCodigoPago() {
        return codigoPago;
    }

    public void setCodigoPago(String codigoPago) {
        this.codigoPago = codigoPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Integer getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(Integer estadoPago) {
        this.estadoPago = estadoPago;
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

    public Alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Salon getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(Salon idSalon) {
        this.idSalon = idSalon;
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
        hash += (idMatricula != null ? idMatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.idMatricula == null && other.idMatricula != null) || (this.idMatricula != null && !this.idMatricula.equals(other.idMatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Matricula[ idMatricula=" + idMatricula + " ]";
    }
    public String getEstadoString() {
        String est = "";
        List<DbEstado> estados = (new DbEstado()).getEstadosMatricula();
        for (int i = 0; i < estados.size(); i++) {
            if ( estados.get(i).getId() == this.estado ) {
                est = estados.get(i).getNombre();
                break;
            }
        }
        return est;
    }
    public String getCreadoString(){
        String creadoText = "";
        if(this.creado != null){
            creadoText = new SimpleDateFormat("dd/MM/yyyy KK:mm a").format(this.creado);
        }
        return creadoText;
    }
}
