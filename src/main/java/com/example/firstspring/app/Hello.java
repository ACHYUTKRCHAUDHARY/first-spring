package com.example.firstspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Hello {
//    getmapping is the method level annotation
    @GetMapping("/")
//    requestmapping is the class and method level annotation
    @RequestMapping(value = "/",method = {RequestMethod.GET, RequestMethod.POST})
    public String home() {
        return "<h1>Server is Up!</h1><p>You have successfully mapped the root URL.</p>";
    }
}
