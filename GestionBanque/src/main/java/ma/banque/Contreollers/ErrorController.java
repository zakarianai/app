package ma.banque.Contreollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    @GetMapping(path = "/error")
    public String errorPage(){
        return "error/error";
    }
}
