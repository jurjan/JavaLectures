package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Manager extends User implements Serializable {

    public Manager(String login, String password, LocalDate birthDate) {
        super(login, password, birthDate);
    }

    @Override
    public String toString() {
        return "Free text, ka noriu";
    }
}
