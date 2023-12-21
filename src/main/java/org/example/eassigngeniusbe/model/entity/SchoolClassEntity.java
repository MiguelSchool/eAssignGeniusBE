package org.example.eassigngeniusbe.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.eassigngeniusbe.model.entity.abstracts.AbstractEntity;
import org.example.eassigngeniusbe.model.entity.teacher.TeacherEntity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class SchoolClassEntity extends AbstractEntity {

    @Column(nullable = false)
    private String classname;

    @Column(nullable = false)
    private String classRoom;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private GradeLevelEntity gradeLevelEntity;

    @ManyToOne
    private TeacherEntity classTeacher;

    @ToString.Exclude
    @ManyToMany(mappedBy = "schoolClassEntities")
    private Set<SubjectSchoolClassEntity> schoolSubjectSchoolClassEntities = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SchoolClassEntity that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(classname, that.classname) && Objects.equals(classRoom, that.classRoom)
                && Objects.equals(gradeLevelEntity, that.gradeLevelEntity)
                && Objects.equals(classTeacher, that.classTeacher)
                && Objects.equals(schoolSubjectSchoolClassEntities, that.schoolSubjectSchoolClassEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), classname, classRoom, gradeLevelEntity, classTeacher, schoolSubjectSchoolClassEntities);
    }
}
