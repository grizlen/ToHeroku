package ru.griz.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.griz.main.entities.Document;

@Repository
public interface DocumentsRepository extends JpaRepository<Document, Long> {
}
