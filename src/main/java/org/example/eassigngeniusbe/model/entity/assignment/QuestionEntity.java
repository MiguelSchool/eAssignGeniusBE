package org.example.eassigngeniusbe.model.entity.assignment;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.eassigngeniusbe.model.entity.abstracts.AbstractEntity;
import org.example.eassigngeniusbe.model.entity.student.StudentQuestionAnswerEntity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class QuestionEntity extends AbstractEntity {

    private String question;

    private String solution;

    @OneToMany(mappedBy = "question")
    @ToString.Exclude
    private Set<StudentQuestionAnswerEntity> studentAnswers = new HashSet<>();

    @ManyToOne
    private AssignmentSheetEntity assignmentSheetEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionEntity that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(question, that.question) && Objects.equals(solution, that.solution)
                && Objects.equals(studentAnswers, that.studentAnswers)
                && Objects.equals(assignmentSheetEntity, that.assignmentSheetEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), question, solution, studentAnswers, assignmentSheetEntity);
    }
}
