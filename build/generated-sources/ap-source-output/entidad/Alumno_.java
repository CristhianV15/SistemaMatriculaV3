package entidad;

import entidad.Apoderado;
import entidad.Matricula;
import entidad.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2022-07-16T22:46:55")
@StaticMetamodel(Alumno.class)
public class Alumno_ { 

    public static volatile SingularAttribute<Alumno, Integer> idAlumno;
    public static volatile SingularAttribute<Alumno, String> apellidoPaterno;
    public static volatile SingularAttribute<Alumno, Integer> estado;
    public static volatile SingularAttribute<Alumno, Date> fechaNacimiento;
    public static volatile SingularAttribute<Alumno, String> direccion;
    public static volatile SingularAttribute<Alumno, Date> modificado;
    public static volatile SingularAttribute<Alumno, String> nombres;
    public static volatile SingularAttribute<Alumno, String> apellidoMaterno;
    public static volatile SingularAttribute<Alumno, String> tipoDocumento;
    public static volatile SingularAttribute<Alumno, Date> creado;
    public static volatile SingularAttribute<Alumno, Usuario> idUsuarioCreado;
    public static volatile CollectionAttribute<Alumno, Matricula> matriculaCollection;
    public static volatile SingularAttribute<Alumno, String> numeroDocumento;
    public static volatile SingularAttribute<Alumno, String> sexo;
    public static volatile SingularAttribute<Alumno, Apoderado> idApoderado;

}