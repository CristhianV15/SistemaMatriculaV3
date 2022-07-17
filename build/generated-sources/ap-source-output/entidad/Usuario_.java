package entidad;

import entidad.Alumno;
import entidad.Matricula;
import entidad.Salon;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2022-07-17T16:24:58")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile CollectionAttribute<Usuario, Alumno> alumnoCollection;
    public static volatile SingularAttribute<Usuario, String> clave;
    public static volatile SingularAttribute<Usuario, String> tipo;
    public static volatile SingularAttribute<Usuario, Integer> estado;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile CollectionAttribute<Usuario, Salon> salonCollection;
    public static volatile SingularAttribute<Usuario, Date> modificado;
    public static volatile SingularAttribute<Usuario, String> nombreUsuario;
    public static volatile SingularAttribute<Usuario, Date> creado;
    public static volatile CollectionAttribute<Usuario, Matricula> matriculaCollection1;
    public static volatile CollectionAttribute<Usuario, Matricula> matriculaCollection;
    public static volatile SingularAttribute<Usuario, String> email;
    public static volatile CollectionAttribute<Usuario, Salon> salonCollection1;

}