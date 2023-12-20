package org.example.eassigngeniusbe.model.entity.assignment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.eassigngeniusbe.model.entity.teacher.AssignmentSheetFeedbackEntity;
import org.example.eassigngeniusbe.model.entity.SubjectSchoolClassEntity;
import org.example.eassigngeniusbe.model.entity.teacher.TeacherEntity;
import org.example.eassigngeniusbe.model.entity.abstracts.AbstractEntity;
import org.example.eassigngeniusbe.model.entity.student.StudentAssignmentGradeEntity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class AssignmentSheetEntity extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String module;

    @ToString.Exclude
    @OneToMany(mappedBy = "assignmentSheetEntity")
    private Set<QuestionEntity> questionEntities = new HashSet<>();

    @ManyToOne
    private SubjectSchoolClassEntity subjectSchoolClassEntity;

    @ManyToOne
    private TeacherEntity teacher;

    @ToString.Exclude
    @OneToMany(mappedBy = "assignmentSheet")
    private Set<StudentAssignmentGradeEntity> studentAssignmentGradeEntities = new HashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "assignmentSheet")
    private Set<AssignmentSheetFeedbackEntity> assignmentFeedbacks = new HashSet<>();

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof AssignmentSheetEntity that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(name, that.name) && Objects.equals(module, that.module)
                && Objects.equals(questionEntities, that.questionEntities)
                && Objects.equals(subjectSchoolClassEntity, that.subjectSchoolClassEntity)
                && Objects.equals(teacher, that.teacher)
                && Objects.equals(studentAssignmentGradeEntities, that.studentAssignmentGradeEntities)
                && Objects.equals(assignmentFeedbacks, that.assignmentFeedbacks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, module, questionEntities, subjectSchoolClassEntity, teacher, studentAssignmentGradeEntities, assignmentFeedbacks);
    }
}
