package CarsHelper;

import CarsClass.CarsClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CarsHelper {

    // Добавми машину
    public void addCar(CarsClass car, SessionFactory factory) {

        Session session = factory.openSession();
        session.beginTransaction();

        session.save(car);

        session.getTransaction().commit();
        session.close();
    }

    public void getCarinUd(int id, SessionFactory factory) {
        try (Session session = factory.openSession()) {
            CarsClass car = session.get(CarsClass.class, id);
            session.close();

            System.out.println(car.model);

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
