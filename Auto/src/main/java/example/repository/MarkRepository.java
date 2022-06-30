package example.repository;

import example.domain.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarkRepository extends JpaRepository<Mark, Long> {

    Mark findMarkByName(String name);

}
