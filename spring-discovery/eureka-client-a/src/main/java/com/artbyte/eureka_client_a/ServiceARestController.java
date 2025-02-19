package com.artbyte.eureka_client_a;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceARestController {

    @GetMapping("/serviceA")
    public String saludoDesdeA(){
        return "Saludo desde Service A";
    }
}
