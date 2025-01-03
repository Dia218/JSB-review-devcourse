package Jar.com.mysite.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    //생성한 QuestionRepository 인터페이스를 리포지토리로 만들기 위해 JpaRepository를 상속한다.
    //JpaRepository는 JPA가 제공하는 인터페이스중 하나로 CRUD작업을 처리하는 메서드들을 이미 내장하고 있어 데이터
    //관리 작업을 좀 더 편리하게 처리할 수 있다.
    //JpaRepository<Question, Integer>은 Question 엔티티로 리포지터리를 생성한다는 의미이다.
    //Question 엔티티의 기본키가 Integer임을 이와 같이 추가로 지정해야한다.
    Question findBySubject(String subject);

    Question findBySubjectAndContent(String subjecty, String content);

    List<Question> findBySubjectLike(String subject);

}

