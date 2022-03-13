package ru.griz.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.griz.main.entities.ReturnItem;

import java.util.List;

public interface ReturnItemRepository extends JpaRepository<ReturnItem, Long> {
    List<ReturnItem> findAllByDocId(Long docId);
}
