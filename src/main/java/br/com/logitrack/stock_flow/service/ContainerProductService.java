package br.com.logitrack.stock_flow.service;

import br.com.logitrack.stock_flow.entity.ContainerProduct;
import br.com.logitrack.stock_flow.form.ContainerProductForm;
import br.com.logitrack.stock_flow.repository.ContainerProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ContainerProductService {

    private final ContainerProductRepository repository;

    public ContainerProductService(ContainerProductRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Long registerContainer(ContainerProductForm form) {
        ContainerProduct cont = repository.save(form.toEntity());
        return cont.getId();
    }

}
