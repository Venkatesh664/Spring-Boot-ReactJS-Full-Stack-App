package com.praveen.Employee.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;
    private String emailId;

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
