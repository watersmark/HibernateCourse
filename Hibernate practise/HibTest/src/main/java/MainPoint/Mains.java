package MainPoint;

import CarsClass.CarsClass;
import CarsHelper.CarsHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import SessionFactoryCreate.FactoryCreate;

public class Mains {
    public static void main(String[] args) {

        FactoryCreate create = new FactoryCreate();
        CarsHelper helper = new CarsHelper();

        CarsClass car = new CarsClass();
        car.setAllParam(7, "Forma", 73000);

        // Создаём Session factory
        SessionFactory factory = create.createFactory();

        //Добавляем машину
        //helper.addCar(car, factory);

        Session session = factory.openSession();
        CarsClass classCar = session.get(CarsClass.class, 7);


        System.out.println("End work");
    }
}
