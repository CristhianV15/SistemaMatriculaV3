package entidad;

import entidad.Salon;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2022-07-16T22:46:55")
@StaticMetamodel(Grado.class)
public class Grado_ { 

    public static volatile SingularAttribute<Grado, Integer> estado;
    public static volatile SingularAttribute<Grado, Date> creado;
    public static volatile SingularAttribute<Grado, Integer> idGrado;
    public static volatile SingularAttribute<Grado, String> nombreGrado;
    public static volatile CollectionAttribute<Grado, Salon> salonCollection;
    public static volatile SingularAttribute<Grado, Integer> rotulo;
    public static volatile SingularAttribute<Grado, String> nivel;

}