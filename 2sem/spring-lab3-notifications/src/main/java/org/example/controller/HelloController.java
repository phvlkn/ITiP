package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Spring Boot!";
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "Goodbye Spring Boot!";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam("name") String name) {
        return "Greeting " + name;
    }

    @GetMapping("/info")
    public String info(@RequestParam("name") String name, @RequestParam("age") int age) {
        return "Hello " + name + " " + age;
    }
}
