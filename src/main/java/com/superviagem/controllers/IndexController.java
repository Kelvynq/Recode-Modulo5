package com.superviagem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
    public String index() {
        return "index";
    }
	
	@GetMapping("/login")
    public String login() {
        return "login";
    }
	
	@GetMapping("/promocoes")
    public String promocoes() {
        return "promocoes";
    }
	
	@GetMapping("/contato")
    public String contato() {
        return "contato";
    }

}
