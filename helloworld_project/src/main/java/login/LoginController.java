package login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
@RequestMapping("login")
public class LoginController {
 
    @RequestMapping(value="")
    String loginForm() {
        return "login/loginForm";
    }
}