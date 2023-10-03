package com.kuka.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUser {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
}
