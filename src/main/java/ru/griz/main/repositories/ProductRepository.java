package ru.griz.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.griz.main.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
