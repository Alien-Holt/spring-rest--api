package service;

import dto.LanguageDTO;
import exception.NullEntityUpdateException;
import model.Language;
import org.springframework.stereotype.Service;
import repository.LanguageRepository;
import service.interfaces.ILanguageService;

import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@Service
public class LanguageService implements ILanguageService {
    private final LanguageRepository languageRepository;
    private final Logger logger = LogManager.getLogManager().getLogger(String.valueOf(LanguageService.class));

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<LanguageDTO> getAllLanguages() {
        return parseDTOList(languageRepository.findAllByOrderByName());
    }

    private List<LanguageDTO> parseDTOList(List<Language> languages) {
        return languages.stream().map(LanguageDTO::new).collect(Collectors.toList());
    }

    @Override
    public LanguageDTO getLanguagesByIdNo(Integer languageIdNo) {
        try {
            return new LanguageDTO(languageRepository.findByIdNo(languageIdNo));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addLanguage(LanguageDTO languageDTO) {
        Language language = languageDTO.toEntity();
        language.setIdNo(null);
        languageRepository.save(language);
    }

    @Override
    public void updateLanguage(Integer languageIdNo, LanguageDTO languageDTO) {
        Language language = languageRepository.findByIdNo(languageIdNo);

        if (language == null) {
            throw new NullEntityUpdateException();
        } else {
            language.copyValues(languageDTO.toEntity());
            language.setIdNo(languageIdNo);
            languageRepository.save(language);
        }

    }

    @Override
    public void deleteLanguageByIdNo(Integer languageIdNo) {
        languageRepository.deleteByIdNo(languageIdNo);
    }
}
