package com.example.yootday1.dto.parent;

import com.example.yootday1.domain.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentUpsertRequest {

    private String fullName;

    private String phone;

    private String email;

    private String address;

    private String relationship;

    private Gender gender = Gender.OTHER;
}
