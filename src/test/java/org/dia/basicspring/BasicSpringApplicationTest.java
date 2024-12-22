package org.dia.basicspring;

import org.dia.basicspring.question.Question;
import org.dia.basicspring.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BasicSpringApplicationTest {
    @Autowired
    private QuestionRepository questionRepository;
    
    String questionSubject1 = "What`s the sbb?";
    String questionContent1 = "I want to know the sbb.";
    String questionSubject2 = "I have a question about SpringBoot.";
    String questionContent2 = "Is the ID automatically generated?";
    
    @Test
    void test_question_save() {
        Question question1 = new Question();
        question1.setSubject(questionSubject1);
        question1.setContent(questionContent1);
        question1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(question1);
        
        Question question2 = new Question();
        question2.setSubject(questionSubject2);
        question2.setContent(questionContent2);
        question2.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(question2);
    }
    
    @Test
    void test_question_saveCheckAll() {
        List<Question> questionAll = this.questionRepository.findAll();
        assertEquals(2, questionAll.size());
        
        Question question = questionAll.getFirst();
        assertEquals(questionSubject1, question.getSubject());
    }
    
    @Test
    void test_question_saveCheck() {
        Optional<Question> optionalQuestion = this.questionRepository.findById(1);
        
        if(optionalQuestion.isPresent()) {
            Question question = optionalQuestion.get();
            assertEquals(questionSubject1, question.getSubject());
        }
    }
    
    @Test
    void test_question_findBySubject() {
        Question question = this.questionRepository.findBySubject(questionSubject1);
        assertEquals(1, question.getId());
    }
    
    @Test
    void test_question_findBySubjectAndContent() {
        Question question = this.questionRepository.findBySubjectAndContent(
                questionSubject1, questionContent1
        );
        assertEquals(1, question.getId());
    }
    
    @Test
    void test_question_findBySubjectLike() {
        List<Question> questionList = this.questionRepository.findBySubjectLike("%sbb%");
        Question question = questionList.getFirst();
        assertEquals(questionSubject1, question.getSubject());
    }
    
    @Test
    void test_question_update() {
        Optional<Question> optionalQuestion = this.questionRepository.findById(2);
        assertTrue(optionalQuestion.isPresent());
        Question question = optionalQuestion.get();
        question.setSubject("수정된 제목");
        this.questionRepository.save(question);
        assertNotEquals(questionSubject2, question.getSubject());
    }
    
    @Test
    void test_question_delete() {
    
    }
}