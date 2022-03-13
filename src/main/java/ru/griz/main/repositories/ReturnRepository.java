package ru.griz.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.griz.main.entities.ReturnHeader;

@Repository
public interface ReturnRepository extends JpaRepository<ReturnHeader, Long> {
}
