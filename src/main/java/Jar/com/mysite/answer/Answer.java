package Jar.com.mysite.answer;

import Jar.com.mysite.question.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @ManyToOne
    private Question question;
    //답변 엔티티에서는 질문 엔티티를 참조하기 위해 question 인스턴스를 추가하였다.
}
