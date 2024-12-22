package org.dia.basicspring;

import jakarta.transaction.Transactional;
import org.dia.basicspring.answer.Answer;
import org.dia.basicspring.answer.AnswerRepository;
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
class AnswerRepositoryTest {
    @Autowired
    private QuestionRepository questionRepository;
    
    @Autowired
    private AnswerRepository answerRepository;
    
    String answerContent = "Yes, it is.";
    
    @Test
    void test_answer_save() {
        Optional<Question> optionalQuestion = this.questionRepository.findById(2);
        assertTrue(optionalQuestion.isPresent());
        Question question = optionalQuestion.get();
        
        Answer answer = new Answer();
        answer.setContent(answerContent);
        answer.setQuestion(question);
        answer.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(answer);
    }
    
    @Test
    void test_answer_saveByQuestion() {
        Optional<Answer> optionalAnswer = this.answerRepository.findById(1);
        assertTrue(optionalAnswer.isPresent());
        Answer answer = optionalAnswer.get();
        assertEquals(2, answer.getQuestion().getId());
    }
    
    @Transactional
    @Test
    void test_answer_saveCheckByQuestion() {
        Optional<Question> optionalQuestion = this.questionRepository.findById(2);
        assertTrue(optionalQuestion.isPresent());
        Question question = optionalQuestion.get();
        
        List<Answer> answerList = question.getAnswerList();
        
        assertEquals(3, answerList.size());
        assertEquals(answerContent, answerList.getFirst().getContent());
    }
}