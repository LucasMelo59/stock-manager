package br.com.logitrack.stock_flow.controller;

import br.com.logitrack.stock_flow.form.ContainerProductForm;
import br.com.logitrack.stock_flow.service.ContainerProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("container/product")
public class ContainerProductController {

    private final ContainerProductService service;

    public ContainerProductController(ContainerProductService service) {
        this.service = service;
    }

    @PostMapping
    @RequestMapping("/register")
    public Long register(@RequestBody ContainerProductForm form) {
        return service.registerContainer(form);
    }

}
