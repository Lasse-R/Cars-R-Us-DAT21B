package dat3.carsrus.repository;

import dat3.carsrus.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    boolean existsByCar_IdAndRentalDate(int carId, LocalDate localDate);

}
