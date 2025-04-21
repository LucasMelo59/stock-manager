package br.com.logitrack.stock_flow.controller;

import br.com.logitrack.stock_flow.form.UserForm;
import br.com.logitrack.stock_flow.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    @RequestMapping("/register")
    public Long registerUser(@RequestBody UserForm form) {
        return service.registerUser(form);
    }

}
