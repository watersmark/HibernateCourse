package CarsClass;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cars")
public class CarsClass {

    @Id
    public int idCar;
    public String model;
    public int cost;


    public void setAllParam(int id, String model, int cost){
        this.idCar = id;
        this.model = model;
        this.cost = cost;
    }

}
