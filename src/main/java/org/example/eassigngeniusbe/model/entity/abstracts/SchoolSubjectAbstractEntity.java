package org.example.eassigngeniusbe.model.entity.abstracts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.example.eassigngeniusbe.model.enumaration.SchoolSubject;

import java.util.Objects;

@Entity
@Getter
@Setter
public abstract class SchoolSubjectAbstractEntity extends AbstractEntity {

    @Column(nullable = false)
    private SchoolSubject subjectName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SchoolSubjectAbstractEntity that)) return false;
        if (!super.equals(o)) return false;
        return subjectName == that.subjectName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subjectName);
    }
}
