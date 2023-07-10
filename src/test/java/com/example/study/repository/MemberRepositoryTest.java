package com.example.study.repository;

import com.example.study.entity.Member;
import com.example.study.entity.Team;
import com.fasterxml.classmate.members.RawMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class MemberRepositoryTest {

	@Autowired
	MemberRepository memberRepository;
	@ Autowired                          
	TeamRepository teamRepository;
	@Autowired	
	EntityManager em; //JPA관리 핵심객체

	JPAQueryFactory factory = new JPAQueryFactory(em);;

	@BeforeEach
	void testInsertData(){

		Team teamA = Team.builder()
				.name("teamA")
				.build();
		Team teamB = Team.builder()
				.name("teamB")
				.build();
		teamRepository.save(teamA);
		teamRepository.save(teamB);

		Member member1 = Member.builder().
		userName("member1")
				.age(10).team(teamA).build();
		Member member2 = Member.builder().
		userName("member1")
				.age(20).team(teamA).build();
		Member member3 = Member.builder()
						.userName("member1")
				.age(30)
				.team(teamB)
				.build();

		Member member4 = Member.builder().
		userName("member1")
				.age(40)
				.team(teamB)
				.build();

		memberRepository.save(member1);
		memberRepository.save(member2);
		memberRepository.save(member3);
		memberRepository.save(member4);

	}

	
	@Test
	@DisplayName("start QueryDls")
	void startQueryDls() {
	    //given
		
	    //when

	    //then
	}
	

}