package ru.griz.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.griz.main.entities.SaleItem;

import java.util.List;

public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {
    List<SaleItem> findAllByDocId(Long docId);
}
