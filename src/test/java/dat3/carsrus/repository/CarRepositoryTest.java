package dat3.carsrus.repository;

import dat3.carsrus.entity.Car;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    static int vehicle1;
    static int vehicle2;

    @BeforeAll
    public static void setupCars (@Autowired CarRepository carRepository) {
        carRepository.deleteAll();
        Car car1 = new Car("audi", "a5", 4500, 500);
        Car car2 = new Car("kia", "proceed", 3500, 350);
        carRepository.save(car1);
        carRepository.save(car2);

        vehicle1 = car1.getId();
        vehicle2 = car2.getId();
    }

    @Test
    public void testFindCarByBrand () {

        Car testVehicle = carRepository.findCarByBrand("audi");

        assertEquals(vehicle1, testVehicle.getId());
    }

    @Test
    public void testFindCarByModel() {

        Car testVehicle = carRepository.findCarByModel("proceed");

        assertEquals(vehicle2, testVehicle.getId());
    }


}