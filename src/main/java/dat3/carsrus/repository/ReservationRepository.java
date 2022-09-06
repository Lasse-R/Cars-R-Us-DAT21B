package dat3.carsrus.repository;

import dat3.carsrus.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

    boolean existsByCar_IdAndRentalDate(int carId, LocalDate localDate);

}
