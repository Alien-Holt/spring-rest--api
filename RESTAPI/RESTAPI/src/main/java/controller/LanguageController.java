package controller;

import dto.LanguageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.interfaces.ILanguageService;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {

    private final ILanguageService iLanguageService;

    @Autowired
    public LanguageController(ILanguageService iLanguageService) {
        this.iLanguageService = iLanguageService;
    }

    @GetMapping
    public List<LanguageDTO> getAllLanguages() {
        return iLanguageService.getAllLanguages();
    }

    @GetMapping("/{idNo}")
    public LanguageDTO getLanguageByIdNo(@PathVariable Integer idNo) {
        return iLanguageService.getLanguagesByIdNo(idNo);
    }

    @PostMapping
    public void addLanguage(@RequestBody LanguageDTO languageDTO) {
        iLanguageService.addLanguage(languageDTO);
    }

    @PutMapping("/{idNo}")
    public void updateLanguage(@PathVariable Integer idNo, @RequestBody LanguageDTO languageDTO) {
        iLanguageService.updateLanguage(idNo, languageDTO);
    }

    @DeleteMapping("/{idNo}")
    public void deleteLanguage(@PathVariable Integer idNo) {
        iLanguageService.deleteLanguageByIdNo(idNo);
    }

}
