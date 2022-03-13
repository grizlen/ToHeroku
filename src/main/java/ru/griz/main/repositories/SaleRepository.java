package ru.griz.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.griz.main.entities.SaleHeader;

@Repository
public interface SaleRepository extends JpaRepository<SaleHeader, Long> {
}
