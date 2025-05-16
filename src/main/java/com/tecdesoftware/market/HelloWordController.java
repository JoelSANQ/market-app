package com.tecdesoftware.market;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")

public class HelloWordController {
    @GetMapping("/hola")
    public String saludar(){
        return "Bye World, Jaime \uD83D\uDE2B \uD83D\uDE3C \uD83D\uDD25";
    }
}
