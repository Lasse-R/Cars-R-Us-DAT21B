package dat3.carsrus.repository;

import dat3.carsrus.entity.Member;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    static String mem1;
    static String mem2;

    @BeforeAll
    public static void setupMember(@Autowired MemberRepository memberRepository) {
        memberRepository.deleteAll();
        Member member1 = new Member("bruger", "kodeord", "test@123.dk", "John");
        Member member2 = new Member("user", "password", "123@test.dk", "Hillary");

        memberRepository.save(member1);
        memberRepository.save(member2);

        mem1 = member1.getUsername();
        mem2 = member2.getUsername();
    }

    @Test
    public void findMemberByUsername(){
        Member test = memberRepository.findMemberByUsername("bruger");

        assertEquals(mem1, test.getUsername());
    }


    @Test
    public void findMemberByFirstName() {
        Member test = memberRepository.findMemberByFirstName("Hillary");

        assertEquals(mem2, test.getUsername());
    }
}