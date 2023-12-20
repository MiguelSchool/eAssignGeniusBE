package org.example.eassigngeniusbe.model.entity.abstracts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
public abstract class UserEntity extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String surName;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(email, that.email) && Objects.equals(password, that.password) &&
                Objects.equals(firstName, that.firstName) && Objects.equals(surName, that.surName) &&
                Objects.equals(age, that.age) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, password, firstName, surName, age, address);
    }
}
