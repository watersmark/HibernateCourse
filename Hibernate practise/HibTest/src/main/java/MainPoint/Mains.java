package MainPoint;

import CarsClass.CarsClass;
import CarsHelper.CarsHelper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import SessionFactoryCreate.FactoryCreate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Iterator;
import java.util.List;

public class Mains {
    public static void main(String[] args) {
        // Создаём фабрику
        FactoryCreate create = new FactoryCreate();
        // Создаём вспомогательный класс
        CarsHelper helper = new CarsHelper();

        CarsClass car = new CarsClass();
        car.setAllParam(10, "Topa", 66000);

        SessionFactory factory = create.createFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        CarsClass car1 = new CarsClass();
        car1.setAllParam(155, "Toyota", 780_000);

        CarsClass car2 = session.get(CarsClass.class, 48);
        car2.model= "Pejo";

        session.save(car1);
        session.save(car2);

        session.getTransaction().commit();
        session.close();


        System.out.println("End programm");
    }
}
