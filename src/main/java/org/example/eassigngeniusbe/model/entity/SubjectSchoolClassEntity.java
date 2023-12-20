package org.example.eassigngeniusbe.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.eassigngeniusbe.model.entity.abstracts.SchoolSubjectAbstractEntity;
import org.example.eassigngeniusbe.model.entity.assignment.AssignmentSheetEntity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class SubjectSchoolClassEntity extends SchoolSubjectAbstractEntity {

    @Column(nullable = false)
    private Boolean isMandatorySubject;

    @Column(nullable = false)
    private Boolean isElectiveSubject;

    @ToString.Exclude
    @OneToMany(mappedBy = "subjectSchoolClassEntity")
    private Set<AssignmentSheetEntity> assignmentSheetEntities = new HashSet<>();

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "subject_school_class",
            joinColumns = @JoinColumn(name = "school_subject_id"),
            inverseJoinColumns = @JoinColumn(name = "school_class_entity_id")
    )
    private Set<SchoolClassEntity> schoolClassEntities = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubjectSchoolClassEntity that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(isMandatorySubject, that.isMandatorySubject)
                && Objects.equals(isElectiveSubject, that.isElectiveSubject)
                && Objects.equals(assignmentSheetEntities, that.assignmentSheetEntities)
                && Objects.equals(schoolClassEntities, that.schoolClassEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isMandatorySubject, isElectiveSubject, assignmentSheetEntities, schoolClassEntities);
    }
}
