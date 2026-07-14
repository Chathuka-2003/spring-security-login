package com.codewithck.jwt.controller;

import com.codewithck.jwt.service.JWTService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    //Inject jwt service
    private final JWTService jwtService;

    public HomeController(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping
    public String getHello(){
        return "Hi ....";
    }
    @PostMapping("/login")
    public String login(){
        return jwtService.getJWTToken();
    }
    @GetMapping("username")
    public String getUserName(@RequestParam String token){
        return jwtService.getUserName(token);
    }
}
