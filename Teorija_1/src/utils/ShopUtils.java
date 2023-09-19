package utils;

import model.Customer;
import model.Manager;
import model.Shop;
import model.User;

import java.time.LocalDate;
import java.util.Scanner;

public class ShopUtils {
    public static void generateUserMenu(Scanner scanner, Shop shop) throws Exception {
        var cmd = "";

        while (!cmd.equals("q")) {
            System.out.println("""
                    Ka veiksi?
                    c - create user
                    d - delete user
                    r - view user
                    u - update user
                    ra - read all users
                    q - return to main menu""");

            cmd = scanner.nextLine();

            switch (cmd) {
                case "c":
                    System.out.println("Which type? C/M");
                    var type = scanner.nextLine();
                    if (type.equals("C")) {
                        System.out.println("create customer: login;psw;b-date(2000-01-01);addr;cardNo;");
                        String[] userInfo = scanner.nextLine().split(";");
                        Customer customer = new Customer(userInfo[0], userInfo[1], LocalDate.parse(userInfo[2]), userInfo[3], userInfo[4]);
                        shop.getAllUsers().add(customer);
                    } else if (type.equals("M")) {
                        //Labai panasu i customer tik bus manager related info

                    } else {
                        System.out.println("U despair me\n");
                    }
                case "d":
                    break;
                case "r":
                    System.out.println("enter user login\n");
                    var userLogin = scanner.nextLine();
                    User user = shop.getAllUsers().stream().filter(u -> u.getLogin().equals(userLogin)).findFirst().orElse(null);
                    if (user.getClass() == Customer.class) {
                        Customer customer = (Customer) user;
                        System.out.println(customer);
                    } else if (user.getClass() == Manager.class) {
                        Manager manager = (Manager) user;
                        System.out.println(manager);
                    } else {
                        System.out.println("Unknown info\n");
                    }


                    //System.out.println(user);
                    break;
                case "ra":
                    shop.getAllUsers().forEach(System.out::println);
                    break;
                case "u":
                    break;
                default:
                    System.out.println("Learn to read\n");

            }

        }
    }
}
