package pl.test.projectforsignup.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// TODO: no todo actually, made it to make sure security works on credentials
@RestController
public class TestController {

    @GetMapping("/")
    public String sayHi() {
        return "Hi";
    }
}
