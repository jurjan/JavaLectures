import model.Shop;
import utils.FileUtils;
import utils.ShopUtils;

import java.util.Scanner;

public class StartNoInterface {
    public static void main(String[] args) {

        //Sita man reikia kurti tik jei failas blogas arba nera
        Shop shop = FileUtils.readFromFile("shop.txt");
        if (shop == null)
            shop = new Shop();

        Scanner scanner = new Scanner(System.in);
        var cmd = 0;

        while (cmd != 3) {
            System.out.println("""
                    Yo wassup! Su kuo dirbsi?
                    1 - User
                    2 - Warehouse
                    3 - quit
                    4 - write to file""");

            cmd = scanner.nextInt();
            scanner.nextLine();

            switch (cmd) {
                case 1:
                    try {
                        ShopUtils.generateUserMenu(scanner, shop);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    FileUtils.writeToFile("shop.txt", shop);
                    break;
                default:
                    System.out.println("Wrong number\n");

            }
        }


    }
}
