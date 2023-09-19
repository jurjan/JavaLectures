package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Galim nerasyti getteriu ir setteriu o naudoti lombok

//Arba visur naudojat lombok arba susitvarkot patys

//@NoArgsConstructor
//@Getter
//Laikina klase, kad patogiau butu i faila irasyti
public class Shop implements Serializable {
    private List<User> allUsers;
    private List<Warehouse> allWarehouses;

    public Shop(List<User> allUsers, List<Warehouse> allWarehouses) {
        this.allUsers = allUsers;
        this.allWarehouses = allWarehouses;
    }

    public Shop() {
        this.allUsers = new ArrayList<>();
        this.allWarehouses = new ArrayList<>();
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<User> allUsers) {
        this.allUsers = allUsers;
    }

    public List<Warehouse> getAllWarehouses() {
        return allWarehouses;
    }

    public void setAllWarehouses(List<Warehouse> allWarehouses) {
        this.allWarehouses = allWarehouses;
    }
}
