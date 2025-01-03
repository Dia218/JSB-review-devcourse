package Jar.com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//해당 클래스가 컨트롤러의 기능을 수행한다는 의미
public class HelloController {

    @GetMapping("/hello")
    //get방식의 url요청을 위해 @GetMapping을 사용했다.
    //get 방식 -> 데이터를 url에 노출시키며 요청. 서버에서 데이터를 조회하거나 읽기 위한 목적으로 사용
    //post 방식 -> 데이터를 숨겨서 요청.. 로그인 정보와 같은 민감한 데이터를 서버에 제출하거나 저장을 목적
    @ResponseBody
    //hello메서드의 출력 결과가 문자열 그 자체임을 나타낸다.
    //해당 에노테이션을 명시하지 않을 경우 html 방식처럼 body부분에 hello메서드가 출력된다.
    public String hello() {
        return "Hello SBB";
    }
}
