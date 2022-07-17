package entidad;

import entidad.Alumno;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2022-07-16T22:46:55")
@StaticMetamodel(Apoderado.class)
public class Apoderado_ { 

    public static volatile CollectionAttribute<Apoderado, Alumno> alumnoCollection;
    public static volatile SingularAttribute<Apoderado, String> apellidoPaterno;
    public static volatile SingularAttribute<Apoderado, Integer> estado;
    public static volatile SingularAttribute<Apoderado, String> direccion;
    public static volatile SingularAttribute<Apoderado, Date> modificado;
    public static volatile SingularAttribute<Apoderado, String> nombres;
    public static volatile SingularAttribute<Apoderado, String> apellidoMaterno;
    public static volatile SingularAttribute<Apoderado, String> tipoDocumento;
    public static volatile SingularAttribute<Apoderado, Date> creado;
    public static volatile SingularAttribute<Apoderado, String> celular;
    public static volatile SingularAttribute<Apoderado, String> numeroDocumento;
    public static volatile SingularAttribute<Apoderado, Integer> idApoderado;
    public static volatile SingularAttribute<Apoderado, String> email;

}