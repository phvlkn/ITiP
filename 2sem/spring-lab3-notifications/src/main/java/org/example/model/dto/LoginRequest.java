package org.example.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    @NotBlank(message = "мейл обязателен")
    @Email(message = "формат мейла")
    private String email;

    @NotBlank(message = "пароль пустой")
    private String password;
}
