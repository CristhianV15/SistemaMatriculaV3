package entidad;

import entidad.Salon;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2022-07-20T22:29:59")
@StaticMetamodel(Turno.class)
public class Turno_ { 

    public static volatile SingularAttribute<Turno, String> nombreTurno;
    public static volatile SingularAttribute<Turno, Integer> estado;
    public static volatile SingularAttribute<Turno, Date> creado;
    public static volatile CollectionAttribute<Turno, Salon> salonCollection;
    public static volatile SingularAttribute<Turno, Integer> idTurno;

}