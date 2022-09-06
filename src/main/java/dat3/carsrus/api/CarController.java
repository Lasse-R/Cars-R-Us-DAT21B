package dat3.carsrus.api;

import dat3.carsrus.dto.CarRequest;
import dat3.carsrus.dto.CarResponse;
import dat3.carsrus.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {

    CarService carService;

    public CarController (CarService carService){
        this.carService = carService;
    }

    // Security ADMIN / USER with different levels of details
    @GetMapping
    List<CarResponse> findCars (){
        return carService.findCars();
    }

    // Security ADMIN
    @PostMapping
    CarResponse addCar(@RequestBody CarRequest body){
        return carService.addCar(body);
    }

    //Security ADMIN ???
    @GetMapping(path = "/{id}")
    CarResponse getCarById(@PathVariable int id) throws Exception {
        return carService.findCarById(id);
    }

}
