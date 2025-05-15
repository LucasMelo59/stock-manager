package br.com.logitrack.stock_flow.service;

import br.com.logitrack.stock_flow.entity.ContainerProduct;
import br.com.logitrack.stock_flow.form.ContainerProductForm;
import br.com.logitrack.stock_flow.repository.ContainerProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public List<ContainerProduct> findAll() {
        return repository.findAll();
    }

    // READ - Get by ID
    public Optional<ContainerProduct> findById(Long id) {
        return repository.findById(id);
    }

    // UPDATE
    @Transactional
    public boolean updateContainer(Long id, ContainerProductForm form) {
        Optional<ContainerProduct> optional = repository.findById(id);
        if (optional.isPresent()) {
            ContainerProduct entity = optional.get();
            entity.setName(form.name());
            entity.setDescription(form.description());
            entity.setLocation(form.location());
            entity.setType(form.type());
            entity.setUpdateAt(LocalDateTime.now());
            repository.save(entity);
            return true;
        }
        return false;
    }

    // DELETE (soft delete, atualiza o active para false)
    @Transactional
    public boolean deleteContainer(Long id) {
        Optional<ContainerProduct> optional = repository.findById(id);
        if (optional.isPresent()) {
            ContainerProduct entity = optional.get();
            entity.setActive(false);
            entity.setUpdateAt(LocalDateTime.now());
            repository.save(entity);
            return true;
        }
        return false;
    }

}
