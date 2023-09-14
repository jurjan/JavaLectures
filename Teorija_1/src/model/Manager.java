package model;

import java.time.LocalDate;

public class Manager extends User{

    public Manager(String login, String password, LocalDate birthDate) {
        super(login, password, birthDate);
    }
}
