package dto;

import model.Language;

import java.util.Objects;

public class LanguageDTO {

    private Integer idNo;
    private String name;
    private String description;
    private Integer code;

    public LanguageDTO(Integer idNo, String name, String description, Integer code) {
        this.idNo = idNo;
        this.name = name;
        this.description = description;
        this.code = code;
    }

    public Language toEntity() {
        Language language = new Language();
        language.setIdNo(idNo);
        language.setName(name);
        language.setDescription(description);
        language.setCode(code);
        return language;
    }

    public LanguageDTO(Language byIdNo) {
    }

    public Integer getIdNo() {
        return idNo;
    }

    public void setIdNo(Integer idNo) {
        this.idNo = idNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LanguageDTO that = (LanguageDTO) o;
        return idNo.equals(that.idNo) && name.equals(that.name) && Objects.equals(description, that.description) && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNo, name, description, code);
    }


}
