package com.fitness.ADT.gateway.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank(message = "EMAIL IS REQUIRED!")
    @Email(message = "INVALID EMAIL FORMAT!")
    private String email;
    @NotBlank(message = "PASSWORD IS REQUIRED")
    @Size(min = 6, message = "PASSWORD MUST HAVE ATLEAST 6 CHARACTERS%")
    private String keycloakId;
    private String password;
    private String firstName;
    private String lastName;
}
