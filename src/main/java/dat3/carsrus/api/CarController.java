package dat3.carsrus.api;

import dat3.carsrus.dto.CarResponse;
import dat3.carsrus.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {

    CarService carService;

    public CarController (CarService carService){
        this.carService = carService;
    }

    // Security ADMIN / USER
    @GetMapping
    List<CarResponse> findCars (){
        return carService.findCars();
    }

}
