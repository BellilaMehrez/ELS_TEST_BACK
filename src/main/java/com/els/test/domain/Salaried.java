package com.els.test.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

/**
 * A Salaried.
 */
@Document
public class Salaried {

    @Id
    private String id;

    private String fullName;

    private String address;

    private String category;

    private String description;

    public Salaried() {
    }

    public Salaried(String id, String fullName, String address, String category, String description) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.category = category;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salaried salaried = (Salaried) o;
        return Objects.equals(id, salaried.id) &&
                Objects.equals(fullName, salaried.fullName) &&
                Objects.equals(address, salaried.address) &&
                Objects.equals(category, salaried.category) &&
                Objects.equals(description, salaried.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, address, category, description);
    }

    @Override
    public String toString() {
        return "Salaried{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
