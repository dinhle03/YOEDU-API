package com.example.yootday1.dto.teacher;

import com.example.yootday1.domain.enums.TeacherRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherUpsertRequest {
    private String teacherCode;

    private String fullName;

    private String phone;

    private String email;

    private TeacherRole teacherRole = TeacherRole.TEACHER;

    private String cccdImageUrl;

    private Boolean isActive = true;
}
