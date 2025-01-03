package Jar.com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@Controller 작성 시 MainController 클래스는 스프링부트의 컨트롤러가 된다.
public class MainController {

    @GetMapping("sbb")
    //index메서드의 @GetMapping 에너테이션은 요청된 URL과의 매핑을 담당하낟.
    //브라우저가 URL을 요청하면 스프링 부트는 요청 페이지와 매핑되는 메서드를 찾아 실행한다.
    @ResponseBody
    //URL 요청에 대한 응답으로 문자열을 리턴하라는 의미이다.
    //해당 에노테이션이 생략되었을 시  스프링부트는 index라는 템플릿 파일을 찾게 될 것이다.
    public String index() {
        return "안녕하세요 sbb에 오신 것을 환영합니다";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }
}
