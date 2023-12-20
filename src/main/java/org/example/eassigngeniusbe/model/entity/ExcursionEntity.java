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
public class ExcursionEntity extends EventEntity {

    @Column(nullable = false)
    private Double coasts = 0d;

    @Column(nullable = false)
    private Boolean isApproved;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExcursionEntity that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(coasts, that.coasts) && Objects.equals(isApproved, that.isApproved);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coasts, isApproved);
    }
}
