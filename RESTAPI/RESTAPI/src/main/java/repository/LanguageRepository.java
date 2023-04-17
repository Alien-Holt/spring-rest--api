package repository;

import model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language, Integer> {

    Language findByIdNo(Integer idNo);

    List<Language> findAllByOrderByName();

    Language deleteByIdNo(Integer idNo);
}
