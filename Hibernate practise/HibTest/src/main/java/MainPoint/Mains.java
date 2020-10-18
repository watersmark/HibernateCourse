package MainPoint;

import CarsClass.CarsClass;
import CarsHelper.CarsHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import SessionFactoryCreate.FactoryCreate;

import java.util.List;

public class Mains {
    public static void main(String[] args) {
        // Создаём фабрику
        FactoryCreate create = new FactoryCreate();
        // Создаём вспомогательный класс
        CarsHelper helper = new CarsHelper();

        CarsClass car = new CarsClass();
        car.setAllParam(7, "Forma", 73000);

        SessionFactory factory = create.createFactory();
        Session session = factory.openSession();

        Query query = session.createQuery("from CarsClass WHERE cost =: cost");
        query.setParameter("cost", 1200);
        List list = query.list();

        
        for(Object cars :list){
            System.out.println(((CarsClass) cars).model);
        }


        System.out.println("End work");
    }
}
