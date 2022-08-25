package dat3.carsrus.repository;

import dat3.carsrus.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Integer> {

    Car findCarByBrand(String brand);

    Car findCarByModel(String brand);

}
