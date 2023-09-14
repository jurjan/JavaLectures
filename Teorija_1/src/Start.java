import model.Customer;
import model.Warehouse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
//        Customer customer = new Customer();
//        Warehouse warehouse = new Warehouse("Test address", new ArrayList<>());
// warehouse.setAddress("Test address");
        //  System.out.println(warehouse.getAddress() + " " + warehouse.getInStock());
        Scanner scanner = new Scanner(System.in);
        var cmd = 0;

        while(cmd != 3){
            System.out.println("""
                Yo wassup! Su kuo dirbsi?
                1 - User
                2 - Warehouse
                3 - quit""");

            cmd = scanner.nextInt();
            scanner.nextLine();

            switch (cmd){
                case 1:
                    //Negeneruoju meniu kol kas, tik sukuriu user
                    System.out.println("create customer: login;psw;b-date(2000-01-01);addr;cardNo;");
                    String values = scanner.nextLine(); //admin;admin;2000-01-01;dsa;dasd
                    String[] info = values.split(";");
                    User customer = new Customer(info[0], info[1], LocalDate.parse(info[2]),info[3], info[4]);
                    System.out.println(customer);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Wrong number\n");

            }
        }


    }
}
