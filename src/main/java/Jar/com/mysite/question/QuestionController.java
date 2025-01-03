package Jar.com.mysite.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/question")
//반복되는 프리픽스는 @RequestMapping()을 통해 괄호안에 선언하여 후에 맵핑에서 생략할 수 있다.
@RequiredArgsConstructor
//Lombok이넹?
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    //@RequestMapping("/question") 을 클래스 위에 선언함으로써 해당 에노테이션은
    //@GetMapping("/question/list") 와 같다.
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }

    @GetMapping(value = "/detail/{id}")
    //@RequestMapping("/question") 을 클래스 위에 선언함으로써 해당 에노테이션은
    //@GetMapping("/question/detail/{id}") 와 같다.
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
}
