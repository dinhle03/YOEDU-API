package com.example.yootday1.dto.parent;

import com.example.yootday1.domain.enums.Gender;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentUpsertRequest {
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
    @Size(max = 255)
    private String address;
    @Size(max = 10)
    private String relationship;
    @NotNull
    @Size(max = 10)
    private Gender gender = Gender.OTHER;
}
