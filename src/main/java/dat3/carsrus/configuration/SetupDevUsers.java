package dat3.carsrus.configuration;

import dat3.carsrus.entity.Car;
import dat3.carsrus.entity.Member;
import dat3.carsrus.entity.Reservation;
import dat3.carsrus.repository.CarRepository;
import dat3.carsrus.repository.MemberRepository;
import dat3.security.entity.Role;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;
import dat3.security.repository.UserWithRolesRepository;

import java.time.LocalDate;

@Controller
public class SetupDevUsers implements ApplicationRunner {

    UserWithRolesRepository userWithRolesRepository;
    MemberRepository memberRepository;

    CarRepository carRepository;

    public SetupDevUsers(UserWithRolesRepository userWithRolesRepository, MemberRepository memberRepository, CarRepository carRepository) {
        this.userWithRolesRepository = userWithRolesRepository;
        this.memberRepository = memberRepository;
        this.carRepository = carRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        Member mem1 = new Member(
                "admin",
                "admin",
                "admin@admin.dk",
                "Lasse",
                "Rasmussen",
                "test avenue",
                "Hvidovre",
                "2650",
                true,
                Role.ADMIN
        );

        Member mem2 = new Member("bruger", "bruger123", "bruger@user.dk", "Tester",
                "Testersen", "Street", "Herlev", "2600", false, Role.USER);

        memberRepository.save(mem1);
        memberRepository.save(mem2);

        Car car1 = new Car("Volkswagen", "Golf", 1500, 300);
        Car car2 = new Car("Skoda", "Citigo", 1200, 250);
        carRepository.save(car1);
        carRepository.save(car2);


        Reservation reservation1 = new Reservation(mem1, car1, LocalDate.of(2022,9,6));
        mem1.addReservation(reservation1);
        memberRepository.save(mem1);

    }



    /*****************************************************************************************
     Jeg har slettet den eksisterende metode som oprettede brugere her i klassen og lavet en simpel
     rettelse i "run" metoden som opretter 2 typer brugere, en ADMIN og en USER.
     *****************************************************************************************/

}
