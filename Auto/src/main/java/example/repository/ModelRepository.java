package example.repository;

import example.domain.Mark;
import example.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ModelRepository extends JpaRepository<Model, Long> {

    List<Model> findModelByNameAndMark(String name, Mark mark);
}
