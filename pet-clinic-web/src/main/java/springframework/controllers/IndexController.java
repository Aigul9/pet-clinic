package springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    // list of acceptable paths
    @GetMapping({"", "/", "index", "index.html"})
    public String index() {
        // thymeleaf template name
        return "index";
    }
}
