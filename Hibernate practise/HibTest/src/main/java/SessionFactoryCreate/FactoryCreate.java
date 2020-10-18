package SessionFactoryCreate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryCreate {

    public SessionFactory createFactory(){

        return new Configuration().configure().buildSessionFactory();
    }

}
