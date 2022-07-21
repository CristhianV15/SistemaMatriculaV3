package entidad;

import entidad.Ciclo;
import entidad.Grado;
import entidad.Matricula;
import entidad.Seccion;
import entidad.Turno;
import entidad.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2022-07-20T23:37:50")
@StaticMetamodel(Salon.class)
public class Salon_ { 

    public static volatile SingularAttribute<Salon, Integer> idSalon;
    public static volatile SingularAttribute<Salon, Usuario> idUsuarioModificado;
    public static volatile SingularAttribute<Salon, Ciclo> idCiclo;
    public static volatile SingularAttribute<Salon, Integer> estado;
    public static volatile SingularAttribute<Salon, Date> creado;
    public static volatile SingularAttribute<Salon, Usuario> idUsuarioCreado;
    public static volatile SingularAttribute<Salon, Grado> idGrado;
    public static volatile SingularAttribute<Salon, Date> modificado;
    public static volatile CollectionAttribute<Salon, Matricula> matriculaCollection;
    public static volatile SingularAttribute<Salon, Integer> vacantes;
    public static volatile SingularAttribute<Salon, Seccion> idSeccion;
    public static volatile SingularAttribute<Salon, Turno> idTurno;

}