package jpabook.jpashop.domain.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
    @Rollback(value = false)
    public void 회원가입() throws Exception{
        //given
        Member member = new Member();
        member.setName("Kim");

        //when
        Long saveId = memberService.join(member);
        //then
        em.flush();
        assertEquals(member, memberRepository.findOne(saveId));

    }

    @Test
    public void 중복_회원_예외() throws Exception{
        Member member1 = new Member();
        member1.setName("Kim");

        Member member2 = new Member();
        member2.setName("Kim");

        memberService.join(member1);
        try {
            memberService.join(member2); //예외가 발생해야한다..!
        }catch (IllegalStateException e){
            return;
        }


        fail("예외가 발생해야 한다!!");

    }
}