package chromo.ec.breadindex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/public")
    public String index(){
        return "index";
    }

}
