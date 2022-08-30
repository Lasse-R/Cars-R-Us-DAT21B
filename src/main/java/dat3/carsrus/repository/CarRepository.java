package dat3.carsrus.repository;

import dat3.carsrus.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {

    Car findCarByBrand(String brand);

    Car findCarByModel(String brand);

}
