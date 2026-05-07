package com.example.yootday1.dto.teacher;

import com.example.yootday1.domain.enums.TeacherRole;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherUpsertRequest {
    @NotBlank
    @Size(max = 20)
    private String teacherCode;
    @NotBlank
    @Size(min = 2, max = 100)
    private String fullName;
    @NotBlank
    @Size(max = 20)
    @Pattern(regexp = "^(84|0[35789])+([0-9]{8})$")
    private String phone;
    @Email
    @Size(max = 100)
    private String email;
    @NotNull
    private TeacherRole teacherRole = TeacherRole.TEACHER;
    @Size(max = 255)
    private String cccdImageUrl;

    private Boolean isActive = true;
}
