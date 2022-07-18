package entidad;

import entidad.Salon;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2022-07-17T22:24:27")
@StaticMetamodel(Seccion.class)
public class Seccion_ { 

    public static volatile SingularAttribute<Seccion, Integer> estado;
    public static volatile SingularAttribute<Seccion, Date> creado;
    public static volatile CollectionAttribute<Seccion, Salon> salonCollection;
    public static volatile SingularAttribute<Seccion, Integer> idSeccion;
    public static volatile SingularAttribute<Seccion, String> nombreSeccion;

}