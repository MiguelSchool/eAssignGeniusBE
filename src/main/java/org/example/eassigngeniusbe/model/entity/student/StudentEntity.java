package org.example.eassigngeniusbe.model.entity.student;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.eassigngeniusbe.model.entity.abstracts.UserEntity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class StudentEntity extends UserEntity {

    @ToString.Exclude
    @OneToMany(mappedBy = "student")
    Set<StudentAssignmentEntity> studentAssignments = new HashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "student")
    Set<StudentQuestionAnswerEntity> questionAnswers = new HashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "student")
    Set<StudentAssignmentGradeEntity> studentAssignmentGradeEntities = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentEntity that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(studentAssignments, that.studentAssignments)
                && Objects.equals(questionAnswers, that.questionAnswers)
                && Objects.equals(studentAssignmentGradeEntities, that.studentAssignmentGradeEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentAssignments, questionAnswers, studentAssignmentGradeEntities);
    }
}
