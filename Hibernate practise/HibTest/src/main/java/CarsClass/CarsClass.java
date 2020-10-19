package CarsClass;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Generated;

import javax.persistence.*;


@Entity
@Table(name = "cars")
@DynamicUpdate
public class CarsClass {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int idCar;

    @Column(name = "modeles")
    public String model;
    public int cost;


    public void setAllParam(int id, String model, int cost){
        this.idCar = id;
        this.model = model;
        this.cost = cost;
    }

}
