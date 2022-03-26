package ru.griz.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.griz.main.entities.BuyItem;

import java.util.List;

public interface BuyItemRepository extends JpaRepository<BuyItem, Long> {
    List<BuyItem> findAllByDocId(Long docId);
    void deleteByDocId(Long docId);
}
