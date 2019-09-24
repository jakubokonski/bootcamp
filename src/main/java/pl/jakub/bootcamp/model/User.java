package pl.jakub.bootcamp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import pl.jakub.bootcamp.model.enums.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotEmpty(message = "{poleWymagane}")
//    @Pattern(regexp = "^[a-zA-Z]+$", message = "Podaj poprawne imię")
    private String name;
//    @NotEmpty(message = "{pl.jakub.bootcamp.model.User.surname.NotEmpty}")
    private String surname;
//    @Email(message = "Podaj poprawny email")
//    @NotEmpty(message = "{pl.jakub.bootcamp.model.User.email.NotEmpty}")
    private String email;
//    @NotEmpty(message = "{pl.jakub.bootcamp.model.User.phone.NotEmpty}")
//    @Pattern(regexp = "^[0-9]{9}", message = "Podaj poprawny numer telefonu")
    private String phone;

//    @NotEmpty(message = "Wybierz kurs")
    @ManyToOne
    private Course course;

//    @NotEmpty(message = "Wybierz tryb")
    private String type;

//    @Column(unique = true)
    private String userName;
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;

}
