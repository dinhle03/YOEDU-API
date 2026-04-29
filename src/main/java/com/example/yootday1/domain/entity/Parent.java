package com.example.yootday1.domain.entity;

import com.example.yootday1.domain.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "parents")
@Data
public class Parent extends AuditableEntity {
    @Column(columnDefinition = "varchar(100)")
    private String fullName;
    @Column(columnDefinition = "varchar(20)")
    private String phone;
    @Column(columnDefinition = "varchar(100)")
    private String email;
    @Column(columnDefinition = "varchar(255)")
    private String address;
}
