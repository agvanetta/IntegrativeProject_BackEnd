package IntegrativeProject.DentalClinic.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class UserController {

    @GetMapping("/user")
    public String user(){
        return "<h1> Hola usuario! </h1>";
    }

    @GetMapping("/admin")
    public String admin(){
        return "<h1> Hola admin! </h1>";
    }

    @GetMapping("/403")
    public String error() {
        return "<h1>Error 403: Acceso denegado o prohibido</h1>";
    }
}
