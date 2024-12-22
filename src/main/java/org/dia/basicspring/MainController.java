package org.dia.basicspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }
    
    @GetMapping("/test")
    @ResponseBody
    public String index() {
        return "test page";
    }
}
