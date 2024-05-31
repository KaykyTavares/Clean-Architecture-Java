package br.com.course.core.domain;

import br.com.course.core.domain.enums.UserTypeEnum;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class User {
    private UUID id;
    private String email;
    private String password;
    private TaxNumber taxNumber;
    private String fullName;
    private UserTypeEnum type;
    private TransectionPin transectionPin;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User(UUID id, String email, String password, TaxNumber taxNumber, String fullName, UserTypeEnum type, TransectionPin transectionPin, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.taxNumber = taxNumber;
        this.fullName = fullName;
        this.type = type;
        this.transectionPin = transectionPin;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public User(String email, String password, TaxNumber taxNumber, String fullName, UserTypeEnum type, TransectionPin transectionPin) {
        this.email = email;
        this.password = password;
        this.taxNumber = taxNumber;
        this.fullName = fullName;
        this.type = type;
        this.transectionPin = transectionPin;
    }

    public User() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TaxNumber getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(TaxNumber taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UserTypeEnum getType() {
        return type;
    }

    public void setType(UserTypeEnum type) {
        this.type = type;
    }

    public TransectionPin getTransectionPin() {
        return transectionPin;
    }

    public void setTransectionPin(TransectionPin transectionPin) {
        this.transectionPin = transectionPin;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return getId().equals(user.getId()) && getEmail().equals(user.getEmail()) && getPassword().equals(user.getPassword()) && getTaxNumber().equals(user.getTaxNumber()) && getFullName().equals(user.getFullName()) && getType() == user.getType() && getTransectionPin().equals(user.getTransectionPin()) && getCreatedAt().equals(user.getCreatedAt()) && Objects.equals(getUpdatedAt(), user.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getTaxNumber().hashCode();
        result = 31 * result + getFullName().hashCode();
        result = 31 * result + getType().hashCode();
        result = 31 * result + getTransectionPin().hashCode();
        result = 31 * result + getCreatedAt().hashCode();
        result = 31 * result + Objects.hashCode(getUpdatedAt());
        return result;
    }
}
