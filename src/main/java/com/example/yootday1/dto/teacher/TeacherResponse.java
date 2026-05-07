package com.example.yootday1.dto.teacher;

import com.example.yootday1.domain.enums.TeacherRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherResponse {

    private Long id;

    private String teacherCode;

    private String fullName;

    private String phone;

    private String email;

    private TeacherRole teacherRole = TeacherRole.TEACHER;

    private String cccdImageUrl;

    private Boolean isActive = true;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
