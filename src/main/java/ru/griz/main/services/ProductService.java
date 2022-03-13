package ru.griz.main.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.griz.main.entities.Product;
import ru.griz.main.exceptions.ResourceNotFoundException;
import ru.griz.main.repositories.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with Id=" + id + " not found."));
        return product;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}
