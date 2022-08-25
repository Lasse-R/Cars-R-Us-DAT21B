package dat3.carsrus.repository;

import dat3.carsrus.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {

    Member findMemberByUsername(String user);

    Member findMemberByFirstName(String firstName);

}
