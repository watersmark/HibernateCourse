package MainPoint;

import CarsClass.CarsClass;
import CarsHelper.CarsHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import SessionFactoryCreate.FactoryCreate;

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

        for (int i = 0; i < 2000; i++) {


        }


        System.out.println("End programm");

    }
}
