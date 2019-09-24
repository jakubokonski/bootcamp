package pl.jakub.bootcamp.model.dto;

import pl.jakub.bootcamp.model.enums.Role;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UserDTO {

    @NotEmpty(message = "{poleWymagane}")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Podaj poprawne imię")
    private String name;

    @NotEmpty(message = "{pl.jakub.bootcamp.model.User.surname.NotEmpty}")
    private String surname;

    @Email(message = "Podaj poprawny email")
    @NotEmpty(message = "{pl.jakub.bootcamp.model.User.email.NotEmpty}")
    private String email;

    //    @NotEmpty(message = "{pl.jakub.bootcamp.model.User.phone.NotEmpty}")
    @Pattern(regexp = "^[0-9]{9}", message = "Podaj poprawny numer telefonu")
    private String phone;

    @NotEmpty(message = "Wybierz kurs")
    private String course;

    @NotEmpty(message = "Wybierz tryb")
    private String type;

    @Column(unique = true)
    private String userName;
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;
}
