package model;

import java.time.LocalDate;

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
