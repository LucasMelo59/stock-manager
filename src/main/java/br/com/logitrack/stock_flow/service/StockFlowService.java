package br.com.logitrack.stock_flow.service;

import br.com.logitrack.stock_flow.entity.ContainerProduct;
import br.com.logitrack.stock_flow.entity.Product;
import br.com.logitrack.stock_flow.entity.StockFlow;
import br.com.logitrack.stock_flow.entity.User;
import br.com.logitrack.stock_flow.form.StockFlowForm;
import br.com.logitrack.stock_flow.repository.ContainerProductRepository;
import br.com.logitrack.stock_flow.repository.ProductRepository;
import br.com.logitrack.stock_flow.repository.StockFlowRepository;
import br.com.logitrack.stock_flow.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
public class StockFlowService {

    private final StockFlowRepository stockFlowRepository;

    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    private final ContainerProductRepository containerProductRepository;

    public StockFlowService(StockFlowRepository stockFlowRepository, ProductRepository productRepository, UserRepository userRepository, ContainerProductRepository containerProductRepository) {
        this.stockFlowRepository = stockFlowRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.containerProductRepository = containerProductRepository;
    }

    @Transactional
    public Long registerStockFlow(StockFlowForm form) {

        Product prod = productRepository.findById(form.productId()).get();

        User user = userRepository.findById(form.userId()).get();

        ContainerProduct cont = containerProductRepository.findById(form.containerId()).get();

        StockFlow stock = stockFlowRepository.save(form.toEntity(prod, user, cont));

        return stock.getId();
    }

    public List<StockFlow> getAllByUser(Long userId) {
        return stockFlowRepository.findAllByUser(userRepository.findById(userId).get());
    }

}
