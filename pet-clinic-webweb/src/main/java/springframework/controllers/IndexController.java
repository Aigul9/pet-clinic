package springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    // list of acceptable paths
    @RequestMapping({"", "/", "index", "index.html"})
    public String index() {
        // thymeleaf template name
        return "index";
    }
}
