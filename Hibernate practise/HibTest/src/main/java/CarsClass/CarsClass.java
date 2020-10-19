package CarsClass;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cars")
@DynamicUpdate
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
