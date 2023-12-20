package org.example.eassigngeniusbe.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.eassigngeniusbe.model.entity.abstracts.EventEntity;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
public class ScheduleEntity extends EventEntity {

    @Column(nullable = false)
    private String typeOfAppointment;

    @Column(nullable = false)
    private Boolean isAppointmentForParents;

    @Column(nullable = false)
    private Boolean isAppointmentForTeachers;

    @Column(nullable = false)
    private Boolean isAppointmentForStudent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScheduleEntity that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(typeOfAppointment, that.typeOfAppointment)
                && Objects.equals(isAppointmentForParents, that.isAppointmentForParents)
                && Objects.equals(isAppointmentForTeachers, that.isAppointmentForTeachers)
                && Objects.equals(isAppointmentForStudent, that.isAppointmentForStudent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfAppointment, isAppointmentForParents, isAppointmentForTeachers, isAppointmentForStudent);
    }
}
