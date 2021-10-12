package me.tristanhoermann.pandaboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Just an initial class for checking if spring works.
 */
@RestController
public class HelloSpring {

    @GetMapping("/hello")
    String hello(){
        return "Hello Spring!";
    }
}
