package com.gap.poc.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/gap")
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld() {
        return "hello";
    }
}
