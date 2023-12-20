package org.example.eassigngeniusbe.model.entity.student;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.eassigngeniusbe.model.entity.assignment.QuestionEntity;
import org.example.eassigngeniusbe.model.entity.abstracts.AbstractEntity;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
public class StudentQuestionAnswerEntity extends AbstractEntity {

    @ManyToOne
    private QuestionEntity question;

    @ManyToOne
    private StudentEntity student;

    private String answer;

    private Boolean isCorrect;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentQuestionAnswerEntity that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(question, that.question)
                && Objects.equals(student, that.student)
                && Objects.equals(answer, that.answer)
                && Objects.equals(isCorrect, that.isCorrect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), question, student, answer, isCorrect);
    }
}
