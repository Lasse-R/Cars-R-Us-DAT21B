package dat3.carsrus.repository;

import dat3.carsrus.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

    Member findMemberByUsername(String user);

    Member findMemberByFirstName(String firstName);

}
