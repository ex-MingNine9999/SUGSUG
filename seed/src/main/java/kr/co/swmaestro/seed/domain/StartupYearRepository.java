package kr.co.swmaestro.seed.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StartupYearRepository extends JpaRepository<StartupYear, String> {
    @Query(value = "SELECT * FROM startup_year WHERE s_id = ?1", nativeQuery = true)
    List<StartupYear> yearBySid(String s_id);
}
