package org.example.eassigngeniusbe.model.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.eassigngeniusbe.model.entity.abstracts.AbstractEntity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
public class GradeLevelEntity extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate beginGradle;

    @Column(nullable = false)
    private LocalDate endGradle;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "gradeLevelEntity")
    private Set<SchoolClassEntity> schoolClassEntities = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GradeLevelEntity that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(name, that.name) && Objects.equals(beginGradle, that.beginGradle)
                && Objects.equals(endGradle, that.endGradle)
                && Objects.equals(schoolClassEntities, that.schoolClassEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, beginGradle, endGradle, schoolClassEntities);
    }
}
