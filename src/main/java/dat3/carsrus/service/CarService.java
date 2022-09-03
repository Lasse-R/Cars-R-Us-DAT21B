package dat3.carsrus.service;

import dat3.carsrus.dto.CarResponse;
import dat3.carsrus.entity.Car;
import dat3.carsrus.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    CarRepository carRepository;

    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public List<CarResponse> findCars (){
        List<Car> cars = carRepository.findAll();
        List<CarResponse> response = cars.stream().map(car -> new CarResponse(car, false)).collect(Collectors.toList());
        return response;
    }
}
