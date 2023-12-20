package org.example.eassigngeniusbe.model.entity.abstracts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
public abstract class EventEntity extends AbstractEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDateTime beginEvent;
    @Column(nullable = false)
    private LocalDateTime endEvent;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Boolean isRemote;

    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventEntity that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(title, that.title) && Objects.equals(beginEvent, that.beginEvent) && Objects.equals(endEvent, that.endEvent) &&
                Objects.equals(location, that.location) && Objects.equals(isRemote, that.isRemote) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, beginEvent, endEvent, location, isRemote, description);
    }
}
