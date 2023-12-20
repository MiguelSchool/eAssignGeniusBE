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
public class StudentAssignmentGradeEntity extends AbstractEntity {

    private String grade;

    @ManyToOne
    private StudentEntity student;

    @ManyToOne
    private AssignmentSheetEntity assignmentSheet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentAssignmentGradeEntity that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(grade, that.grade)
                && Objects.equals(student, that.student)
                && Objects.equals(assignmentSheet, that.assignmentSheet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grade, student, assignmentSheet);
    }
}
