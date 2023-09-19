package model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
public abstract class User implements Serializable {
    int i;
    String login;
    String password;
    LocalDate birthDate;
    //Dar bus


    public User(String login, String password, LocalDate birthDate) {
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
    }

    public User(int i, String login, String password, LocalDate birthDate) {
        this.i = i;
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "login='" + login + '\'' +
//                ", password='" + password + '\'' +
//                ", birthDate=" + birthDate +
//                '}'; //pasikeisti kaip noriu
//    }


    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
