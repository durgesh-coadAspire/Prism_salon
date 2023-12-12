package com.prism.mr.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberUpdatePasswordDto {

    @NotNull
    private Long id;
    @NotNull
    private String password;

}
