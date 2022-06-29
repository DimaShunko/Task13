package example.repository;

import example.domain.Modific;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModificRepository extends JpaRepository<Modific, Long> {
    Optional<Modific> findById(int id);
}
