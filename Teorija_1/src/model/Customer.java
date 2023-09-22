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
public class Customer extends User {
    private String address;
    private String cardNo;

    public Customer(String login, String password, LocalDate birthDate, String address, String cardNo) {
        super(login, password, birthDate);
        this.address = address;
        this.cardNo = cardNo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "address='" + address + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }


}
