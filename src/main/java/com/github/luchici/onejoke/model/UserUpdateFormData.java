package com.github.luchici.onejoke.model;

import com.github.luchici.onejoke.validation.RepeatedPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@RepeatedPassword
public class UserUpdateFormData {

    //  TODO:  Internationalization

    @NotBlank
    @Size(min = 3, max = 12)
    @Pattern(regexp = "^[A-Za-z]+$", message = "need to contain just letters")
    private String firstName;
    @NotBlank
    @Size(min = 3,max = 12)
    @Pattern(regexp = "^[a-zA-Z]+$", message = "need to contain just letters")
    private String lastName;
    @NotBlank
    @Size(min = 3,max = 12)
    @Pattern(regexp = "^[a-zA-Z]+$", message = "need to contain just letters")
    private String username;
    @Past
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 6,max = 20)
    @Pattern(regexp = "^.*?\\d+.*?$", message = "need to contain one or more digits")
    @Pattern(regexp = "(?=.*[A-Z]).*", message = "need to contain one or more capital letters")
    @Pattern(regexp = "(?=.*[a-z]).*", message = "need to contain one or more lowercase letters")
    @Pattern(regexp = "^.*[@#$%^&*()!~]+$", message = "need to contain one or more symbols")
    @Pattern(regexp = "^\\S+$", message = "can`t contain any white spaces")
    private String password;

    private String repeatedPassword;

    @Builder
    public UserUpdateFormData(String firstName, String lastName, String username, LocalDate dob, String email, String password, String repeatedPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.dob = dob;
        this.email = email;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
    }
}
