package org.example.eassigngeniusbe.model.entity.student;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.eassigngeniusbe.model.entity.assignment.AssignmentSheetEntity;
import org.example.eassigngeniusbe.model.entity.abstracts.AbstractEntity;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
public class StudentAssignmentEntity extends AbstractEntity {

    private Boolean completed;

    @ManyToOne
    private StudentEntity student;

    @ManyToOne
    private AssignmentSheetEntity assignmentSheet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentAssignmentEntity that)) return false;
        if (!super.equals(o)) return false;
        return completed == that.completed && Objects.equals(student, that.student) && Objects.equals(assignmentSheet, that.assignmentSheet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), completed, student, assignmentSheet);
    }
}
