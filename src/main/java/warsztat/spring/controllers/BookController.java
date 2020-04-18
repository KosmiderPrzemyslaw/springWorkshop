package spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
W odróżnieniu do MVC dodaliśmy adnotację @RestController - jest to połączenie znanych nam
adnotacji: @ResponseBody i @Controller.
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @GetMapping("/hello")
    public String hello() {
        return "{hello: World}";
    }

}
