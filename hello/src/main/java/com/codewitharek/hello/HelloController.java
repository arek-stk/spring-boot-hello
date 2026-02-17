package com.codewitharek.hello;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
public class HelloController {
    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name) {
        return "Hallo " + name + "!";
    }
    @PostMapping("/hello")
    public String helloPost(@RequestBody HelloRequest request){
        return "Hallo " + request.getName() + "!";
    }

}
