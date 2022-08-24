package dat3.carsrus.configuration;

import dat3.carsrus.entity.Car;
import dat3.carsrus.repository.CarRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

@Controller
public class SetupCars implements ApplicationRunner {

    CarRepository carRepository;


    public SetupCars(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public void run(ApplicationArguments args) {
        Car car1 = new Car("Volkswagen", "Golf", 1500, 300);
        Car car2 = new Car("Skoda", "Citigo", 1200, 250);
        carRepository.save(car1);
        carRepository.save(car2);
    }

    /*****************************************************************************************
     Mere eller mindre en Copy/Paste af "SetupDevUsers" da jeg skulle bruge de samme metoder,
     bare til oprettelse af biler i stedet for. Har oprettet et par stykker og sikret mig at de
     bliver oprettet i databasen via Workbench. Unit Test incoming.
     *****************************************************************************************/
}
