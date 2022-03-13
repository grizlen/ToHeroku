package ru.griz.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.griz.main.entities.BuyHeader;

@Repository
public interface BuyRepository extends JpaRepository<BuyHeader, Long> {
}
