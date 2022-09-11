package dat3.carsrus.service;

import dat3.carsrus.dto.MemberRequest;
import dat3.carsrus.dto.MemberResponse;
import dat3.carsrus.entity.Member;
import dat3.carsrus.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void editMember(MemberRequest body, String username){
        Member member = memberRepository.findById(username).orElseThrow(
                ()->  new ResponseStatusException(HttpStatus.BAD_REQUEST,"Member with this username dont exist"));

        if(!body.getUsername().equals(username)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cannot change username");
        }
        member.setPassword(body.getPassword());
        member.setEmail(body.getEmail());
        member.setFirstName(body.getFirstName());
        member.setLastName(body.getLastName());
        member.setStreet(body.getStreet());
        member.setCity(body.getCity());
        member.setZip(body.getZip());
        memberRepository.save(member);
    }

    public void setRankingForUser(String username, int value) {
        Member member = memberRepository.findById(username).orElseThrow(()->  new ResponseStatusException(HttpStatus.BAD_REQUEST,"Member with this username already exist"));
        member.setRanking(value);
        memberRepository.save(member);
    }

    public List<MemberResponse> findMembers() {
        List<Member> members = memberRepository.findAll();
        List<MemberResponse> response = members.stream().map(member -> new MemberResponse(member, true)).collect(Collectors.toList());


        return response;
    }

    public MemberResponse addMember(MemberRequest memberRequest){
        //Later you should add error checks --> Missing arguments, email taken etc.

        Member newMember = MemberRequest.getMemberEntity(memberRequest);
        newMember = memberRepository.save(newMember);

        return new MemberResponse(newMember, false);
    }

    public MemberResponse findMemberByUsername(String username) throws Exception {
        Member found = memberRepository.findById(username).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));
        return new MemberResponse(found,false);
    }

    public List<MemberResponse> getMembers() {
        List<Member> members = memberRepository.findAll();
        List<MemberResponse> response = members.stream().map(member -> new MemberResponse(member,false)).collect(Collectors.toList());
        return response;
    }

    public void deleteByUsername(String username) {
        memberRepository.deleteById(username);
    }

}
