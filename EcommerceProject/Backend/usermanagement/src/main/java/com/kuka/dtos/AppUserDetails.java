package com.kuka.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppUserDetails {
    @NotBlank
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String roles;
    @NotBlank
    private String email;

    public AppUserDetails(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}
