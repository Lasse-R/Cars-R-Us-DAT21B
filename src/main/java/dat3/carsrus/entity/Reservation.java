package dat3.carsrus.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//--------------everything above is lombok----------------//
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @CreationTimestamp
    LocalDateTime reservationDate;


    LocalDate rentalDate;

    @ManyToOne
    Member member;

    @ManyToOne
    Car car;

    public Reservation(Member member, Car car, LocalDate localdate) {
        this.rentalDate = localdate;
        this.member = member;
        this.car = car;
    }
}
