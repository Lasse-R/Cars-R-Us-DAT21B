package dat3.carsrus.configuration;

import dat3.carsrus.entity.Member;
import dat3.carsrus.repository.MemberRepository;
import dat3.security.entity.Role;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;
import dat3.security.repository.UserWithRolesRepository;

@Controller
public class SetupDevUsers implements ApplicationRunner {

    UserWithRolesRepository userWithRolesRepository;
    MemberRepository memberRepository;

    public SetupDevUsers(UserWithRolesRepository userWithRolesRepository, MemberRepository memberRepository) {
        this.userWithRolesRepository = userWithRolesRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        Member mem1 = new Member("admin", "admin", "admin@admin.dk", "Lasse",
                "Rasmussen", "test avenue", "Hvidovre", 2650, true, Role.ADMIN );

        Member mem2 = new Member("bruger", "bruger123", "bruger@user.dk", "David",
                "Davidson", "Street", "Herlev", 2600, false, Role.USER );

        memberRepository.save(mem1);
        memberRepository.save(mem2);
    }

    /*****************************************************************************************
     Jeg har slettet den eksisterende metode som oprettede brugere her i klassen og lavet en simpel
     rettelse i "run" metoden som opretter 2 typer brugere, en ADMIN og en USER.
     *****************************************************************************************/
}
