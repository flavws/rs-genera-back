package br.com.rsgenera.repository;

import br.com.rsgenera.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
