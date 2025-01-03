package Jar.com.mysite.question;

import Jar.com.mysite.answer.Answer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToMany (mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
    //Answer 객체들로 구성된 answerList를 Question 엔티티의 속성으로 추가하고 @OneToMany 에너테이션을 설정했다.
    //이제 질문에서 답변을 참조하려면 question.getAnserList()를 호출하면 된다. @OneTOMany 에너테이션에서 사용된
    //mappedBy는 참조 엔티티의 속성명을 정의한다. 즉, Answer 엔티티에서 Question 엔티티를 참조한 속성인 question을
    //mappedBy에 전달해야 한다.

}
