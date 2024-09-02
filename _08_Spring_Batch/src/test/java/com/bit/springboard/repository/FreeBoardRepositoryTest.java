package com.bit.springboard.repository;

import com.bit.springboard.config.QueryDslConfiguration;
import com.bit.springboard.entity.FreeBoard;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDateTime;
import java.util.ArrayList;

@DataJpaTest
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// : @DataJpaTest 어노테이션은 임베디드 데이터베이스(H2)를 사용하도록 설정되는데
// 실제 어플리케이션 사용하는 DataSource를 이용하여 테스트를 진행하도록 설정
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(QueryDslConfiguration.class)
public class FreeBoardRepositoryTest {
    @Autowired
    private FreeBoardRepository freeBoardRepository;


    @Test
    void findByIdTest() throws Exception{
        // 기대값을 가지고 있는 FreeBoard 엔티티
        FreeBoard freeBoard = FreeBoard.builder()
                .id(16L)
                .title("나야")
                .content("나")
                .cnt(0)
                .regdate(LocalDateTime.parse("2024-08-30T11:34:26.180626"))
                .moddate(LocalDateTime.parse("2024-08-30T11:34:26.180626"))
                .boardFileList(new ArrayList<>())
                .build();

        // 실제 DB에 저장되어 있는 값을 가지고 있는 FreeBoard
        FreeBoard findByIdFreeBoard = freeBoardRepository.findById(13L)
                .orElseThrow(
                        ()-> new RuntimeException("freeboard not exist")
                );

        // Assertion 객체 : JUint5에서 제공하는 클래스로 테스트 코드에 대한 다양한 검증(Assertion)
        //                 기능을 제공한다. Assertion 클래스는 테스트의 예상결과와 실제 결과를 비교하여
        //                 테스트가 성공했는지 실패했는지 판단한다.
        // assertEqual(기대값, 실제값) : 기대값과 실제값이 동일해야 테스트를 통과시킨다.
        // assertNotEqual(기대값, 실제값) : assertEqual(기대값, 실제값)의 반대
        // assertNotNull(Object, Null일 때 발생시킬 예외메세지): 주어진 객체가 Null인지 아닌지 판단하는 메소드
        Assertions.assertNotNull(findByIdFreeBoard);
        Assertions.assertNotEquals(freeBoard.getTitle(), findByIdFreeBoard.getTitle());
        Assertions.assertNotEquals(freeBoard.getContent(), findByIdFreeBoard.getContent());


    }
}
