package org.example.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    @NotBlank(message = "Имя пустое")
    private String name;

    @NotBlank(message = "имейл обязательно")
    @Email(message = "формат мейла")
    private String email;

    @NotBlank(message = "пароль обязательно")
    @Size(min = 6, message = "пароль больше 6 символов")
    private String password;
}
