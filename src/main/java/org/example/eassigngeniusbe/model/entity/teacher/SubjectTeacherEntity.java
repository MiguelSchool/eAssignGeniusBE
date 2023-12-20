package org.example.eassigngeniusbe.model.entity.teacher;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.eassigngeniusbe.model.entity.abstracts.SchoolSubjectAbstractEntity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class SubjectTeacherEntity extends SchoolSubjectAbstractEntity {

    @Column(nullable = false)
    private Boolean isEmphasis;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "teacher_school_subject",
            joinColumns = @JoinColumn(name = "teacher_school_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private Set<TeacherEntity> teachers = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubjectTeacherEntity that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(isEmphasis, that.isEmphasis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isEmphasis);
    }
}
