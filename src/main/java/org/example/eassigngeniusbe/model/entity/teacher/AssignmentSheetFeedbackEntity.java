package org.example.eassigngeniusbe.model.entity.teacher;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.eassigngeniusbe.model.entity.abstracts.AbstractEntity;
import org.example.eassigngeniusbe.model.entity.assignment.AssignmentSheetEntity;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
public class AssignmentSheetFeedbackEntity extends AbstractEntity {

    private String feedback;

    @ManyToOne
    private TeacherEntity teacher;

    @ManyToOne
    private AssignmentSheetEntity assignmentSheet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AssignmentSheetFeedbackEntity that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(feedback, that.feedback) && Objects.equals(teacher, that.teacher)
                && Objects.equals(assignmentSheet, that.assignmentSheet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), feedback, teacher, assignmentSheet);
    }
}
