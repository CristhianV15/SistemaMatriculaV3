package entidad;

import entidad.Salon;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2022-07-17T22:24:27")
@StaticMetamodel(Ciclo.class)
public class Ciclo_ { 

    public static volatile SingularAttribute<Ciclo, Integer> idCiclo;
    public static volatile SingularAttribute<Ciclo, Integer> estado;
    public static volatile SingularAttribute<Ciclo, String> nombreCiclo;
    public static volatile SingularAttribute<Ciclo, Date> creado;
    public static volatile CollectionAttribute<Ciclo, Salon> salonCollection;

}