package org.junngo.spring.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.stream.Collectors;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/callback")
    public void callback(HttpServletRequest request) throws IOException {
        String test;
        test = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        System.out.println(test);
    }
}
