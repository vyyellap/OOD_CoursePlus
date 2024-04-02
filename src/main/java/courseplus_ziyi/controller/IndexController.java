package courseplus_ziyi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class IndexController {


    @GetMapping("/")
    public String index() {

        return "index";
    }
}
