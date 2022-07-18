package entidad;

import entidad.Alumno;
import entidad.Salon;
import entidad.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2022-07-17T22:24:27")
@StaticMetamodel(Matricula.class)
public class Matricula_ { 

    public static volatile SingularAttribute<Matricula, Salon> idSalon;
    public static volatile SingularAttribute<Matricula, Alumno> idAlumno;
    public static volatile SingularAttribute<Matricula, Usuario> idUsuarioModificado;
    public static volatile SingularAttribute<Matricula, Integer> estado;
    public static volatile SingularAttribute<Matricula, Date> creado;
    public static volatile SingularAttribute<Matricula, Integer> idMatricula;
    public static volatile SingularAttribute<Matricula, Usuario> idUsuarioCreado;
    public static volatile SingularAttribute<Matricula, String> codigoPago;
    public static volatile SingularAttribute<Matricula, Date> modificado;
    public static volatile SingularAttribute<Matricula, Integer> estadoPago;
    public static volatile SingularAttribute<Matricula, Date> fechaPago;

}