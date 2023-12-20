package org.example.eassigngeniusbe.model.entity.teacher;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.eassigngeniusbe.model.entity.SchoolClassEntity;
import org.example.eassigngeniusbe.model.entity.abstracts.UserEntity;
import org.example.eassigngeniusbe.model.entity.assignment.AssignmentSheetEntity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class TeacherEntity extends UserEntity {

    @ToString.Exclude
    @ManyToMany(mappedBy = "teachers")
    private Set<SubjectTeacherEntity> schoolSubjectTeacherEntities;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "classTeacher")
    Set<SchoolClassEntity> schoolClassEntities = new HashSet<>();

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "teacher")
    Set<AssignmentSheetEntity> assignmentSheets = new HashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "teacher")
    private Set<AssignmentSheetFeedbackEntity> assignmentFeedbacks = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeacherEntity that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(schoolSubjectTeacherEntities, that.schoolSubjectTeacherEntities)
                && Objects.equals(schoolClassEntities, that.schoolClassEntities)
                && Objects.equals(assignmentSheets, that.assignmentSheets)
                && Objects.equals(assignmentFeedbacks, that.assignmentFeedbacks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), schoolSubjectTeacherEntities, schoolClassEntities, assignmentSheets, assignmentFeedbacks);
    }
}
