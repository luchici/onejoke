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

    @NotBlank
    @Size(min = 3, max = 12)
    @Pattern(regexp = "^[A-Za-z]+$", message = "{validation.pattern.just-letters}")
    private String firstName;
    @NotBlank
    @Size(min = 3,max = 12)
    @Pattern(regexp = "^[a-zA-Z]+$", message = "{validation.pattern.just-letters}")
    private String lastName;
    @NotBlank
    @Size(min = 3,max = 12)
    @Pattern(regexp = "^[a-zA-Z]+$", message = "{validation.pattern.just-letters}")
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
    @Pattern(regexp = "^.*?\\d+.*?$", message = "{validation.pattern.just-digits}")
    @Pattern(regexp = "(?=.*[A-Z]).*", message = "{validation.pattern.must-capital-letters}")
    @Pattern(regexp = "(?=.*[a-z]).*", message = "{validation.pattern.must-lowercase-letters}")
    @Pattern(regexp = "^.*[@#$%^&*()!~]+$", message = "{validation.pattern.must-symbols}")
    @Pattern(regexp = "^\\S+$", message = "{validation.pattern.no-whitespace}")
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
