package com.example.yootday1.domain.entity;

import com.example.yootday1.domain.AuditableEntity;
import com.example.yootday1.domain.enums.TeacherRole;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "teachers")
@Data
public class Teacher extends AuditableEntity {
    @Column(columnDefinition = "varchar(20)")
    private String teacherCode;
    @Column(columnDefinition = "varchar(100)")
    private String fullName;
    @Column(columnDefinition = "varchar(20)")
    private String phone;
    @Column(columnDefinition = "varchar(100)")
    private String email;
    @Enumerated(EnumType.STRING)
    private TeacherRole teacherRole;
    @Column(columnDefinition = "varchar(255)")
    private String cccdImageUrl;

    private byte isActive;
}
