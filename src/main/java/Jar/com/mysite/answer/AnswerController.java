package Jar.com.mysite.answer;
import Jar.com.mysite.question.Question;
import org.springframework.ui.Model;

import Jar.com.mysite.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final QuestionService questionService;

    @PostMapping("create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id,
                               @RequestParam(value = "content") String content) {
        Question question = this.questionService.getQuestion(id);
        //TODO : 답변을 저장한다.
        return String.format("redirect:/question/detail/%s", id);
    }
}
