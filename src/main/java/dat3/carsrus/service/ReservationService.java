package dat3.carsrus.service;

import dat3.carsrus.entity.Car;
import dat3.carsrus.entity.Member;
import dat3.carsrus.entity.Reservation;
import dat3.carsrus.repository.CarRepository;
import dat3.carsrus.repository.MemberRepository;
import dat3.carsrus.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
public class ReservationService {

    CarRepository carRepository;

    MemberRepository memberRepository;

    ReservationRepository reservationRepository;

    public ReservationService(CarRepository carRepository, MemberRepository memberRepository, ReservationRepository reservationRepository) {
        this.carRepository = carRepository;
        this.memberRepository = memberRepository;
        this.reservationRepository = reservationRepository;
    }

    public void reserveCar(String username, int carId, LocalDate localDate) {

        Member member = memberRepository.findById(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Not Found"));
        Car car = carRepository.findById(carId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vehicle Not Found"));

        if(reservationRepository.existsByCar_IdAndRentalDate(carId, localDate)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vehicle Already Reserved");
        }
            Reservation reservation = new Reservation(member, car, localDate);
            reservationRepository.save(reservation);
    }

}
