package dat3.carsrus.service;

import dat3.carsrus.dto.CarRequest;
import dat3.carsrus.dto.CarResponse;
import dat3.carsrus.dto.MemberResponse;
import dat3.carsrus.entity.Car;

import dat3.carsrus.entity.Member;
import dat3.carsrus.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public CarResponse addCar(CarRequest carRequest){

        Car newCar = CarRequest.getCarEntity(carRequest);
        newCar = carRepository.save(newCar);

        return new CarResponse(newCar, false);
    }

    public CarResponse findCarById(int id) throws Exception {
        Car found = carRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));
        return new CarResponse(found,false);
    }
}
