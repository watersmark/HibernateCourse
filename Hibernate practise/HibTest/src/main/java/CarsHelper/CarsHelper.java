package CarsHelper;

import CarsClass.CarsClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CarsHelper {

    // Добавми машину
    public void addCar(CarsClass car, SessionFactory factory) {

        Session session = factory.openSession();
        session.beginTransaction();

        session.save(car);

        session.getTransaction().commit();
        session.close();
    }

    // Получаем машину по id
    public void getCarinUd(int id, SessionFactory factory) {
        try (Session session = factory.openSession()) {
            CarsClass car = session.get(CarsClass.class, id);
            session.close();

            System.out.println(car.model);

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    // выбрать машину по стоимости
    public void getCostCar(int cost, SessionFactory factory) {
        Session session = factory.openSession();
        Query query = session.createQuery("from CarsClass where cost =: costs");
        query.setParameter("costs", 1200);
        List<CarsClass> list = query.list();

        for (CarsClass cars : list) {
            System.out.println(cars.model);
        }

    }

    // Обновляем модель машины по id
    public  void updateCar(SessionFactory factory, int id){
        Session session = factory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("update CarsClass set model = :models" +
                " where idCar = : id");

        query.setParameter("models", "Porsch");
        query.setParameter("id", id);

        int count = query.executeUpdate();

        session.getTransaction().commit();
        session.close();

        System.out.println("End update");

    }

    public void deleteCar(SessionFactory factory, int id){
        Session session = factory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete CarsClass where idCar =: param");
        query.setParameter("param", id);

        int res = query.executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    // Обновляем поля по id
    public void updateCarID(SessionFactory factory, int id, String model){

        Session session = factory.openSession();
        session.beginTransaction();

        CarsClass cars = session.get(CarsClass.class, id);
        cars.model = model;
        session.save(cars);

        session.getTransaction().commit();

        session.close();

    }

    // Обновлем поля с помощью HQL
    public void updateCarHql(SessionFactory factory, int id, String model){
        Session session = factory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("update CarsClass as cs set cs.model =: param1" +
                " where cs.id =: param2");
        query.setParameter("param1", model);
        query.setParameter("param2", id);

        int res = query.executeUpdate();

        session.getTransaction().commit();
        session.close();

    }


}
