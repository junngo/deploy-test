package org.junngo.spring.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.stream.Collectors;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/callback")
    public void callback(ServletRequest request) throws IOException {
//        String test;
//        test = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
//        System.out.println(test);
        final HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        final HttpServletRequestWrapper requestWrapper = new MyHttpServletRequestWrapper(httpServletRequest);
        final String requestBody = requestWrapper.toString();

        System.out.println(requestBody);

    }
}
