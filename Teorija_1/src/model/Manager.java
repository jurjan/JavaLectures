package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Manager extends User {

    private String employeeId;
    private String medCertificate;
    private LocalDate employmentDate;
    private boolean isAdmin;

    public Manager(String login, String password, LocalDate birthDate) {
        super(login, password, birthDate);
    }

    @Override
    public String toString() {
        return "Free text, ka noriu";
    }
}
