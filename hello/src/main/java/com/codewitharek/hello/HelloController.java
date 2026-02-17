package com.codewitharek.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class HelloController {//Steuerzentrale meines Programms

    private final HelloService helloService;

    public HelloController(HelloService helloService){
        this.helloService = helloService;
    }
    @PostMapping("/hello")//POST->Daten speichern
    public HelloResponse helloPost(@RequestBody HelloRequest request){
        return helloService.addName(request.getName());
    }
    @GetMapping("/hello")//GET->Daten holen
    public HelloListResponse helloGet() {
        return  helloService.getNames();
    }
}
