package dat3.carsrus.dto;

import dat3.carsrus.entity.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarRequest {

    int id;

    String brand;

    String model;

    int pricePerDay;

    int bestDiscount;

    public static Car getCarEntity (CarRequest c) {
        return new Car(c.id, c.brand, c.model, c.pricePerDay, c.bestDiscount);
    }

    public CarRequest(Car c){
        this.id = c.getId();
        this.brand = c.getBrand();
        this.model = c.getModel();
        this.pricePerDay = c.getPricePerDay();
        this.bestDiscount = c.getBestDiscount();
    }

}
