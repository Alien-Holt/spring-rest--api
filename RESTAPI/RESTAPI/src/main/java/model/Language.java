package model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "language")
@Table(name = "language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idNo;

    @Column
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private Integer code;

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
        Language language = (Language) o;
        return idNo.equals(language.idNo) && name.equals(language.name) && Objects.equals(description, language.description) && Objects.equals(code, language.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNo, name, description, code);
    }

    public void copyValues(Language toEntity) {
        idNo = toEntity.idNo;
        name = toEntity.name;
        description = toEntity.description;
        code = toEntity.code;
    }
}
