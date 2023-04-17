package service.interfaces;

import dto.LanguageDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILanguageService {

    List<LanguageDTO> getAllLanguages();

    LanguageDTO getLanguagesByIdNo(Integer languageIdNo);

    void addLanguage(LanguageDTO languageDTO);

    void updateLanguage(Integer languageIdNo, LanguageDTO languageDTO);

    void deleteLanguageByIdNo(Integer languageIdNo);

}
