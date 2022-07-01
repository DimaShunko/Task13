package example.repository;

import example.domain.Model;
import example.domain.Modific;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModificRepository extends JpaRepository<Modific, Long> {

    List<Modific> findModificByNameAndModel(String name, Model model);

    List<Modific> findModificByBeginPeriodGreaterThanAndModel(int beginPeriod, Model model);

    List<Modific> findModificByEndPeriodLessThanAndModel(int endPeriod, Model model);

    List<Modific> findModificByNameAndBeginPeriodGreaterThanAndModel(String name, int beginPeriod, Model model);

    List<Modific> findModificByNameAndEndPeriodLessThanAndModel(String name, int endPeriod, Model model);

    List<Modific> findModificByBeginPeriodGreaterThanAndEndPeriodLessThanAndModel(int beginPeriod, int endPeriod, Model model);

    List<Modific> findModificByNameAndBeginPeriodGreaterThanAndEndPeriodLessThanAndModel(String name, int beginPeriod, int endPeriod, Model model);

}
