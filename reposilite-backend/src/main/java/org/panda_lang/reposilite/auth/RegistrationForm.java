package org.panda_lang.reposilite.auth;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@FieldMatch.AsList({
        @FieldMatch(first = "password", second = "confirmPassword", message = "The confirmation password must match password"),
        @FieldMatch(first = "email", second = "confirmEmail", message = "The confirmation email must match email address")
})
public class RegistrationForm {

    @NotNull @Length(min = 3)
    private String username;
    @NotNull @Length(min = 3)
    private String displayName;
    @NotNull @Length(min = 6)
    private String password;
    private String confirmPassword;
    @Email
    private String email;
    @Email
    private String confirmEmail;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

}