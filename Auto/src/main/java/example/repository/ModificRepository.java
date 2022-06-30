package example.repository;

import example.domain.Model;
import example.domain.Modific;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModificRepository extends JpaRepository<Modific, Long> {

    List<Modific> findModificByNameAndModel(String name, Model model);

    List<Modific> findModificByBeginPeriodAndModel(int beginPeriod, Model model);

    List<Modific> findModificByEndPeriodAndModel(int endPeriod, Model model);

    List<Modific> findModificByNameAndBeginPeriodAndModel(String name, int beginPeriod, Model model);

    List<Modific> findModificByNameAndEndPeriodAndModel(String name, int endPeriod, Model model);

    List<Modific> findModificByBeginPeriodAndEndPeriodAndModel(int beginPeriod, int endPeriod, Model model);

    List<Modific> findModificByNameAndBeginPeriodAndEndPeriodAndModel(String name, int beginPeriod, int endPeriod, Model model);

}
